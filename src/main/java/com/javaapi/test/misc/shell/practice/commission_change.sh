#!/bin/bash
export JAVA_HOME=/home/$USER/software/java
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$CLASSPATH
export PATH=$JAVA_HOME/bin:$PATH

export HADOOP_HOME=/home/$USER/software/hadoop
export HADOOP_CONF_DIR=/home/$USER/software/hadoop/etc/hadoop
export PATH=$HADOOP_HOME/sbin:$HADOOP_HOME/bin:$PATH

export HIVE_HOME=/home/$USER/software/hive
export HIVE_CONF_DIR=/home/$USER/software/hive/conf
export PATH=$HIVE_HOME/bin:$PATH

export REDIS_HOME=/home/$USER/software/redis
export PATH=$REDIS_HOME/bin:$PATH

export LANG="en_US.UTF-8"


today=$(date '+%Y%m%d')
now=$(date "+%Y-%m-%d %H:%M:%S")
echo -e "$now\t处理 $today 的代理费率\n"

cd /home/flight/crontab/commission_change

PID=`cat pid`
echo "当前PID: $$, 原PID:$PID"
ps -p $PID >/dev/null 2>&1
if [ $? -eq 0 ] ; then
    echo "任务正在执行，本次退出！！！！"
    exit 1
fi
echo $$ > pid

hive -e "select time, request, exts from flight_log.iflight_request_log where dt = '$today' and channel='ELong' and log_type='CommissionChange'" > commission_change_hdfs.log

#cat commission_change_hdfs.log.2 > commission_change_hdfs.log

# 同一个id只取时间最新的记录
echo '日志时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;详情</br>' > tosend_header.log
awk -F'\t' 'OFS="&nbsp;&nbsp;&nbsp;&nbsp;"{if (!T[$2] || !T[$2]<$1) {T[$2]=$1;V[$2]=$3}}END{for (a in T)print T[a], V[a]}' commission_change_hdfs.log|sort -k1|sed 's/$/<\/br>/g' > tosend_content.log

cat tosend_header.log > tosend.log
cat tosend_content.log >> tosend.log
#邮箱
to='xxx@xxx.com'
subject='代理费率异常'
content=`cat tosend.log`

echo "$to"
echo "$subject"
echo "$content"
echo ""

[ -s tosend_content.log ] && java -jar /home/flight/crontab/mailalert/mailalert-0.0.1-SNAPSHOT.jar "$to" "$subject" "$content"

rm -f tosend*
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

# 打印个输出 初始化变量
today=$(date '+%Y%m%d')
now=$(date "+%Y-%m-%d %H:%M:%S")
seconds=`date +%s`
seconds_new=`expr $seconds - 3600`
before=$(date -d @$seconds_new  "+%Y-%m-%d %H:%M:%S")

echo $before $now $today


echo -e "$now\t处理 $before - $now 的报告\n"

cd /home/flight/crontab/southern_report

## 对程序加个锁防止并发执行
PID=`cat pid`
echo "当前PID: $$, 原PID:$PID"
ps -p $PID >/dev/null 2>&1
if [ $? -eq 0 ] ; then
    echo "任务正在执行，本次退出！！！！"
    exit 1
fi
echo $$ > pid


hive -e "select  get_json_object(f.exts,'$.route') as f_route, get_json_object(f.exts,'$.departDate') as f_departDate  ,sum(get_json_object(f.exts,'$.total')) as f_total ,sum(get_json_object(f.exts,'$.hasSouthern')) as f_hasSouthern ,sum(get_json_object(f.exts,'$.hasNoSouthern')) as f_hasNoSouthern from flight_log.flight_request_log f where time>'$before' and time < '$now' and  dt = '$today' and log_type='SouthernFlag'   group by  get_json_object(f.exts,'$.route') ,get_json_object(f.exts,'$.departDate')  having f_hasNoSouthern  >= 1  order by f_route ,f_departDate  " > southern_report.log





# 同一个id只取时间最新的记录
echo '路线&nbsp;&nbsp;&nbsp;&nbsp;起飞时间&nbsp;&nbsp;&nbsp;&nbsp;请求次数&nbsp;&nbsp;&nbsp;&nbsp;返回次数&nbsp;&nbsp;&nbsp;&nbsp;未返回次数</br>' > tosend_header.log

cat southern_report.log > tosend_content.log

cat tosend_header.log > tosend.log
cat tosend_content.log >> tosend.log


to='xxx@xxx'
subject='报告'
content=`cat tosend.log`

echo "$to"
echo "$subject"
echo "$content"
echo ""

#[ -s tosend_content.log ] && java -jar /home/flight/crontab/mailalert/mailalert-0.0.1-SNAPSHOT.jar "$to" "$subject" "$content"

#rm -f tosend*
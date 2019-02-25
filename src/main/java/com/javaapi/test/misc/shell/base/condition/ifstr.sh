#!/usr/bin/env bash
#字符串比较最好用双中括号
str1=$1
str2=$2
if [[ -z $str1 ]]; then
echo "str1 is empty"
fi
if [[ -n $str1 ]]; then
echo "str1 is not empty"
fi

#检测相同
if [[ $str1 = $str2 ]] || [[ $str1 = $str2 ]]; then
echo "true"
else
echo "false"
fi
#检测不同
if [[ $str1 != $str2 ]]; then
echo "true"
else
echo "false"
fi

#-------- test 可以代替中括号 进行判断

if test $str1 != $str2 ; then
echo "true"
else
echo "false"
fi


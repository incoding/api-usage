#!/bin/sh
for((x=0;x<20;x++))
do

	curl   -sd "username=a&password=1234562&captcha=a&time=`date +%s%N`" "http://www.baidu.com/login.aspx"  |xargs echo 'www.xxx.com'
	echo '-------'
done

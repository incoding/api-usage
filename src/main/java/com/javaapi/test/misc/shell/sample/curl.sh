#!/bin/sh
for((x=0;x<20;x++))
do
	curl -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '68'
	curl -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '204.83'
	curl -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '84'
	curl -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '164'
	curl -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '74.83'
	echo '-------'
done

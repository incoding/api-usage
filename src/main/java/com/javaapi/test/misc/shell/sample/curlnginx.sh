#!/bin/sh
for((x=0;x<20;x++))
do
	curl  -H "Host:www.xxx.com" -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx"  |xargs echo '66'
	curl  -H "Host:www.xxx.com" -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '204.82'
	curl  -H "Host:www.xxx.com" -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '162'
	curl  -H "Host:www.xxx.com" -sd "username=a&password=1234562&captcha=a" "http://www.baidu.com/login.aspx" |xargs echo '74.82'
	echo '-------'
done

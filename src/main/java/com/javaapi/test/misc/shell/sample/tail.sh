#!/bin/sh
logname=$1
function taillog(){
	tail $logname | while read str
		do
			echo "$str" | grep -q 'tomcat started' &&exit 0
		done
}
#下面的方法暂时不好用
function testtailwhile(){
echo 'test'
while(true)
do	
			tail -n 1 tail.txt | grep -q 'tomcat started' &&exit 0
done
}
taillog

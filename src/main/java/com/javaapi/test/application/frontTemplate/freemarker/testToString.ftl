其他转字符串:
	直接将数字输出为字符串
	方式1 ?c: ${number2?c}    
	方式2 ?string.number:${number2?string.number}  
	输出货币符号: ${number2?string.currency}
	输出百分比符号: ${number2?string.percent}
	------------------
	如果布尔值是true,那么返回yes,否则返回no
	${foo1?string ("yes","no")}
	${foo2?string ("yes","no")}


字符串转其他
	---------------------
	 将字符串转换为数字 ?number :
	${"111.11"?number} 结果为111.11 
	-------------------
	 将字符串转换为日期 :date,time，datetime
	<#assign date1="2009-10-12"?date("yyyy-MM-dd")>
	
	<#assign date2="9:28:20"?time("HH:mm:ss")>
	
	${date1} 结果为2009-10-12 
	
	${date2} 结果为9:28:20 
	



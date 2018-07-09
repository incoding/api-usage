判断字符串
	<#if number2 == 2  >
	判断数字
	</#if>
	<#if 2 == "2"?number  >
	判断数字
	</#if>
	<#if number3 == 3?c  >
	判断字符串
	</#if>
	
	<#if booleanTrue >
	直接判断boolean
	</#if>
	<#if !booleanFalse >
	直接判断 !boolean
	</#if>
	
	<#if mapInner["booleanTrue"] >
	从map里取出Boolean true
	</#if>
	<#if !mapInner["booleanFalse"] >
	从map里取出Boolean  false
	</#if>
	
	<#if booleanTrue == true>
	boolean判断boolean true
	</#if>
	<#if booleanTrue == !false>
	boolean判断boolean false
	</#if>
	
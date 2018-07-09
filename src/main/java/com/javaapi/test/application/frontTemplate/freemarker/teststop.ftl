测试return标签

<#assign a="3" >
<#if a=="2">
	执行判断
	<#stop>
	遇到stop标签,就不会执行这段了
</#if>
没遇到stop标签以下得就不执行

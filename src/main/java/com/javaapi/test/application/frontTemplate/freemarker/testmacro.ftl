<#-- 宏是和某个变量关联的模板片断，以便在模板中通过用户定义指令使用该变量-->

<#macro kkmacro macroparam macroparam2 >

这是macro 传递进来的param==>  ${macroparam} ${macroparam2}
</#macro>

<@kkmacro macroparam=1 macroparam2=2/>
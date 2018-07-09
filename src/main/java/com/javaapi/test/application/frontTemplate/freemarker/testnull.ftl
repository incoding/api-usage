
顶级变量number没有并不会报错
${number}
如果调用number.aaa则会提示number未定义
<#-- ${number.aaa} -->
报错后下面的也会继续输出
--------------
<#-- ${number!123} -->


<#if (!(number??)) >
	用??来返回布尔值
</#if>
<#if (!(number.aaa??)) >  
	会报错,这行就输出不了.因为number就没有
</#if>

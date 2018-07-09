http://freemarker.org/docs/app_faq.html
http://freemarker.org/docs/app_faq.html#faq_nonstring_keys
http://freemarker.org/docs/ref_builtins_hash.html
google freemarker key value


 实际测试外部map声明任何类型,mapInner调用get方法都会报错
<#list mapInner?keys as testKey>
map里面的key:${testKey} ,这么取value时候会报错:  ${mapInner.get(testKey?int)}  
</#list>  
 



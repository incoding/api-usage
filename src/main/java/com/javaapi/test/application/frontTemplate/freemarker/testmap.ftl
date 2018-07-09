
mapInner 被声明为 这样的时候Map<String, Object> mapInner,也就是key为String类型得时候(number, sequence, or string),才生效
key为其他得时候这样调用会报错
<#list mapInner?keys as testKey>
map里面的key:${testKey} ,value: ${mapInner[testKey]}
</#list>





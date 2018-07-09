package com.javaapi.test.testUtil.opensource.reflect.paranamer;

/**
 *   Paranamer专门用来解决获取参数名的问题。其原理是在编译阶段，修改.class文件，在类或接口的字节码文件中增加一个字符串常量，这个常量保存了所有的方法声明信息，包括方法名、参数类型、参数名称。这样在运行时，class loader加载类文件以后，使用Paranamer的api去读取这个字符串，就可以获取参数名称。

 */
public class Client {
}

package com.javaapi.test.test.dataStructure.collectionutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.junit.Test;

/**
 * http://www.ylzx8.cn/zonghe/open-source/248952.html</br>
 * 收集属性
 *
 */
public class ClientForCollections {
	/**
	 *  获取List<Person> 里的 id 得list
	 */
	@Test
	public void testName() throws Exception {
		List<Book> list = new ArrayList<>();
		Book book = new Book();
		book.setCategory("nihao");
		Book book2 = new Book();
		book2.setCategory("nihao2");
		list.add(book);
		list.add(book2);
		List<String> category = new ArrayList<>();
		CollectionUtils.collect(list, new Transformer() {
			@Override
			public Object transform(Object input) {
				if (input instanceof Book) {
					Book newName = (Book) input;
					String categoryNew = newName.getCategory();
					return categoryNew;
				}
				return null;
			}}, category);
		System.err.println(category);
	}
	/**
	 *  获取List<Person> 里的 id 得list
	 *  http://macrochen.iteye.com/blog/1399082</br>
	 */
	@Test
	public void testName2() throws Exception {
		List<Book> list = new ArrayList<>();
		Book book = new Book();
		book.setId(1);
		book.setCategory("nihao");
		Book book2 = new Book();
		book2.setId(2);
		book2.setCategory("nihao2");
		list.add(book);
		list.add(book2);
		Collection<Integer> collect = collect(list, "id");
		Collection<String> collectString = collect(list, "id");
		System.err.println(collect);
		System.err.println(collectString);// 不会报错
		//当解开的时候,会强制转换,所以会报错
//		for (String string : collectString) {
//			System.err.println(string);
//		}
	}
//    @SuppressWarnings("rawtypes")
//	public static  Collection collecttmp(Collection collection, String propertyName) {  
//        return CollectionUtils.collect(collection, new BeanToPropertyValueTransformer(propertyName));  
//    }  
   	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Collection<T> collect(Collection collection, String propertyName) {  
           return CollectionUtils.collect(collection, new BeanToPropertyValueTransformer(propertyName));  
       }  
}

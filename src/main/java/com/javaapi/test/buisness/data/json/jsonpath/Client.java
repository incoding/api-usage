package com.javaapi.test.buisness.data.json.jsonpath;

import java.util.ArrayList;
import java.util.List;

import net.minidev.json.JSONObject;

import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.impl.JacksonProvider;

/**
 *                     
 *  JSONPath   
 * http://tonynju.iteye.com/blog/344424</br>
 * http://www.cnblogs.com/weilunhui/p/3857366.html
 *
 */
public class Client {
	final static String json = "{\"store\": {\"book\": [{\"category\": \"reference\", \"author\": \"Nigel Rees\", \"title\": \"Sayings of the Century\", \"price\": 8.95 }, {\"category\": \"fiction\", \"author\": \"Evelyn Waugh\", \"title\": \"Sword of Honour\", \"price\": 12.99 }, {\"category\": \"fiction\", \"author\": \"Herman Melville\", \"title\": \"Moby Dick\", \"isbn\": \"0-553-21311-3\", \"price\": 8.99 }, {\"category\": \"fiction\", \"author\": \"J. R. R. Tolkien\", \"title\": \"The Lord of the Rings\", \"isbn\": \"0-395-19395-8\", \"price\": 22.99 }], \"bicycle\": {\"color\": \"red\", \"price\": 19.95 }}, \"expensive\": 10 }";
	final static String jsonPath = "{ \"store\": {     \"book\": [       { \"category\": \"reference\",         \"author\": \"Nigel Rees\",         \"title\": \"Sayings of the Century\",         \"price\": 8.95       },       { \"category\": \"fiction\",         \"author\": \"Evelyn Waugh\",         \"title\": \"Sword of Honour\",         \"price\": 12.99,         \"isbn\": \"0-553-21311-3\"       }     ],     \"bicycle\": {       \"color\": \"red\",       \"price\": 19.95     }   } }";
	
	@Test
	public void testJson() {
		JSONObject bookObject  = JsonPath.read(json, "$.store.book[1]");
		System.err.println(bookObject);
		String book1  = JsonPath.read(json, "$.store.book[1].author");
		System.err.println(book1);
		String book2  = JsonPath.read(json, "$.store.book[2].author");
		System.err.println(book2);
		List<JSONObject> bookObjectList = JsonPath.read(json, "$.store.book[*]");
		System.err.println(bookObjectList);
		List<String> authors = JsonPath.read(json, "$.store.book[*].author");
		System.err.println(authors);
		
		//-------------
		List<String> authors2 = JsonPath.read(json, "$..author");
		System.err.println(authors2);
		List<String> every = JsonPath.read(json, "$..*");
		System.err.println(every);
	}
	@Test
	public void test2() throws Exception {
		  //输出book[0]的author值
	    String author = JsonPath.read(jsonPath, "$.store.book[0].author");
		System.err.println(author);

	    //输出全部author的值，使用Iterator迭代
	    List<String> authors = JsonPath.read(jsonPath, "$.store.book[*].author");
		System.err.println(authors);

	    //输出book[*]中category == 'reference'的book
	    List<Object> books = JsonPath.read(jsonPath, "$.store.book[?(@.category == 'reference')]");              
		System.err.println(books);

	    //输出book[*]中price>10的book
	    List<Object> books1 = JsonPath.read(jsonPath, "$.store.book[?(@.price>10)]");
		System.err.println(books1);

	    //输出book[*]中含有isbn元素的book
	    List<Object> books2 = JsonPath.read(jsonPath, "$.store.book[?(@.isbn)]");
		System.err.println(books2);

	    //输出该json中所有price的值
	    List<Double> prices = JsonPath.read(jsonPath, "$..price");
		System.err.println(prices);

	    //可以提前编辑一个路径，并多次使用它
	    JsonPath path = JsonPath.compile("$.store.book[*]");
	    List<Object> books3 = path.read(jsonPath); 
		System.err.println(books3);
	}
	
	@Test
	public void testTransferObject() throws Exception {
		JsonPath.using(new JacksonProvider());
		Book bookObject = JsonPath.read(json, "$.store.book[1]");
		System.err.println(bookObject);
	}
	/**
	 *不好用 -_-
	 */
	@Test
	public void testTransferObject2() throws Exception {
		List<Book> list = new ArrayList<>();
		Book e = new Book();
		e.setCategory("category1");
		
		Book e2 = new Book();
		e2.setCategory("category2");
		list.add(e);
		list.add(e2);
		List<String> bookObject = JsonPath.read(list, "$..category");
		System.err.println(bookObject);
	}
}

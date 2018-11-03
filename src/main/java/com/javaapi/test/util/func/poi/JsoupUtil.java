package com.javaapi.test.util.func.poi;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.javaapi.test.buisness.data.json.fastjson.util.JsonUtil;

public class JsoupUtil{
	@Test
	public void testGetAddress() throws Exception {
		String address = getAddress("http://baike.baidu.com/search?word=吉林师范大学博达学院");
		System.out.println(address);
	}

	public static String getAddress(String string) throws Exception {
		Document document = Jsoup.connect(string).get();
		Elements elementsByClass = document.getElementsByClass("result-title");
		String attr = elementsByClass.get(0).attr("href");
		String readHref = readHref(attr);
		return readHref;
	}

	private static String readHref(String attr) {
		Document document = null;
		try {
			document = Jsoup.connect(attr).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elementsByClass = document.getElementsByClass("biItemInner");
		for (Element element : elementsByClass) {
			String text = element.text();
		
			if(text.indexOf("学校地址") >=0 && text.indexOf("市") >=0) {
				return text;
			}
			if(text.indexOf("所属地区") >=0 && text.indexOf("市") >=0 ) {
				return text;
			}
		}
		return attr;
	}

	public static String getAddressFromDitu(String cellStringValue) {
		Document document = null;
		try {
			document = Jsoup.connect(cellStringValue).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String string = document.getElementsByTag("body").text();
		return string;
	}
	@Test
	public void testName() throws Exception {
		String extracted = parseFromMap("辽宁石油化工大学顺华能源学院");
		System.out.println(extracted);
	}

	public static String parseFromMap(String address) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("http://map.baidu.com/?newmap=1&reqflag=pcmap&biz=1&from=webmap&da_par=baidu&pcevaname=pc3&qt=s&da_src=searchBox.button&wd=");
		stringBuilder.append(address);
		stringBuilder.append("&c=131&src=0&wd2=&sug=0&l=12&b=%2812926672.97,4820723.72;12989648.97,4831091.72%29&from=webmap&force=newsample&sug_forward=&tn=B_NORMAL_MAP&nn=0&ie=utf-8&t=1430923785326");
		String url = stringBuilder.toString();
		String addressFromDitu = getAddressFromDitu(url);
		Map<String, Map<String,String>> map = JsonUtil.getMap(addressFromDitu);
		return map.get("current_city").get("name");
	}
}

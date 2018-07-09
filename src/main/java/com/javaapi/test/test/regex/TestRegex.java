package com.javaapi.test.test.regex;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://www.cnblogs.com/ggjucheng/p/3423731.html</br>
 * 测试正则分组
 *
 */
public class TestRegex {
	/**
	 * 普通字符
	 */
	@Test
	public void testName0() throws Exception {
		String thisMatchName = "food";
		String regex = "oo";
		Matcher matcher = Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
	}

	/**
	 * 测试 {}重复次数
	 *
	 */
	@Test
	public void test1() throws Exception {
		String thisMatchName ="food";
		String regex = "o{1,}";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
	}

	/**
	 * 测试 []用法 ,包含[]里的字符就匹配</br>
	 * [^1,3] 匹配除了1和3
	 */
	@Test
	public void test2() throws Exception {
		String thisMatchName ="food";
		String regex = "[f,o,d]";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
	}
	/**
	 * 测试 []和{}一起用,这样只能获取第一个food
	 * 
	 */
	@Test
	public void test12() throws Exception {
		String thisMatchName ="foodssfodo"; 
		String regex = "[f,o,d]{0,}";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
	}
	/**
	 * 测试 []和{}一起用,获取fodo,注意find(5)
	 * 
	 */
	@Test
	public void test12_1() throws Exception {
		String thisMatchName ="foodssfodo"; 
		String regex = "[f,o,d]{1,}";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find(5));
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
	}
	@Test
	public void test12_2() throws Exception {
		String thisMatchName ="foodssfodo"; 
		String regex = "[f,o,d]{1,}";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher= compile.matcher(thisMatchName);
	    while(matcher.find()){
	    	System.err.println(matcher.group());
	    };
	}
	/**测试分组1
	 * 对于统一匹配matcher,分组group(0)和group()始终是一样得</br>
	 * 对于匹配器 m、输入序列 s 和组索引 g，表达式 m.group(g) 和 s.substring(m.start(g), m.end(g)) 是等效的。</br>

组零表示整个模式，因此表达式 m.group(0) 等效于 m.group()。捕获组是从 1 开始从左到右的索引。 </br>
	 * @throws Exception
	 */
	@Test
	public void testFenZu1() throws Exception {
		String thisMatchName ="sa aa"; 
		String regex = "^(\\w{2})\\s";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
		System.err.println(matcher.group(1));
	}
	/**测试分组2
	 * public int groupCount() </br>

    返回此匹配器模式中的捕获组数。</br>

    根据惯例，零组表示整个模式。它不包括在此计数中。</br>

    任何小于等于此方法返回值的非负整数保证是此匹配器的有效组索引。 </br>
	 * @throws Exception
	 */
	@Test
	public void testFenZu2() throws Exception {
		String thisMatchName ="sa aa"; 
		String regex = "^(\\w{2})\\s([s,a]+)$";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
		System.err.println(matcher.group().equals(matcher.group(0)));
		System.err.println(matcher.group(1));
		System.err.println(matcher.group(2));
	}
	/**测试分组3</br>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFenZu3() throws Exception {
		String thisMatchName ="sa sa";
		String regex = "^(\\w{2})\\s(\\1)$";
		Matcher matcher= Pattern.compile(regex).matcher(thisMatchName);
		System.err.println(matcher.find());
		System.err.println(matcher.groupCount());
		System.err.println(matcher.group());
		System.err.println(matcher.group(0));
		System.err.println(matcher.group(1));
		System.err.println(matcher.group(2));
	}
	/**
	 *	Pattern.split(CharSequence input)
	 */
	@Test
	public void testPatternSplit() throws Exception {
		Pattern p=Pattern.compile("\\d+"); 
		String[] str=p.split("我的QQ是:11111我的电话是:111我的邮箱是:aaa@aaa.com"); 
		System.err.println(Arrays.asList(str));
//		结果:str[0]="我的QQ是:" str[1]="我的电话是:" str[2]="我的邮箱是:aaa@aaa.com" 
	}
	/**
	 * Pattern.matches matches()对整个字符串进行匹配
	 */
	@Test
	public void testPatternMatches() throws Exception {
		System.err.println(Pattern.matches("\\d+","2223"));//返回true 
		System.err.println(Pattern.matches("\\d+","2223aa"));//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
		System.err.println(Pattern.matches("\\d+","22bb23"));//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到 
	}
	/**
	 * lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true  
	 */
	@Test
	public void testLookingAt() throws Exception {
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m=p.matcher("22bb23"); 
		m.lookingAt();//返回true,因为\d+匹配到了前面的22 
		Matcher m2=p.matcher("aa2223"); 
		m2.lookingAt();//返回false,因为\d+不能匹配前面的aa 
	}
	/**
	 * find()对字符串进行匹配,匹配到的字符串可以在任何位置. 
	 */
	@Test
	public void testName() throws Exception {
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m=p.matcher("22bb23"); 
		m.find();//返回true 
		Matcher m2=p.matcher("aa2223"); 
		m2.find();//返回true 
		Matcher m3=p.matcher("aa2223bb"); 
		m3.find();//返回true 
		Matcher m4=p.matcher("aabb"); 
		m4.find();//返回false 
	}
	/**
	 * 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息. 
	 */
	@Test
	public void test_find_start_end_group() throws Exception {
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m=p.matcher("aaa2223bb"); 
		System.err.println(m.groupCount());
		m.find();//匹配2223 
		m.start();//返回3 
		m.end();//返回7,返回的是2223后的索引号 
		System.err.println(m.group());//返回2223 
	}
	@Test
	public void test_lookingat_start_end_group() throws Exception {
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m2=p.matcher("2223bb"); 
		m2.lookingAt();   //匹配2223 
		m2.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0 
		m2.end();   //返回4 
		System.err.println(m2.group());//返回2223 
	}
	@Test
	public void test_find_start_end_group2() throws Exception {
		Pattern p=Pattern.compile("([a-z]+)(\\d+)"); 
		Matcher m=p.matcher("aaa2223bb"); 
		m.find();   //匹配aaa2223 
		m.groupCount();   //返回2,因为有2组 
		m.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号 
		m.start(2);   //返回3 
		m.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置. 
		m.end(2);   //返回7 
		m.group(1);   //返回aaa,返回第一组匹配到的子字符串 
		m.group(2);   //返回2223,返回第二组匹配到的子字符串 
	}
	@Test
	public void testRegex() throws Exception {
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m=p.matcher("我的QQ是:1111 我的电话是:222 我的邮箱是:aaa123@aaa.com"); 
		while(m.find()) { 
		     System.out.println(m.group()); 
		} 
	}
	/**
	 * 现在大家应该知道,每次执行匹配操作后start(),end(),group()三个方法的值都会改变,改变成匹配到的子字符串的信息,以及它们的重载方法,也会改变成相应的信息. 
注意:只有当匹配操作成功,才可以使用start(),end(),group()三个方法,否则会抛出java.lang.IllegalStateException,也就是当matches(),lookingAt(),find()其中任意一个方法返回true时,才可以使用.
	 */
	@Test
	public void testRegex2() throws Exception {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("我的QQ是:1111 我的电话是:222 我的邮箱是:aaa123@aaa.com");
		while (m.find()) {
			System.out.println(m.group());
			System.out.print("start:" + m.start());
			System.out.println(" end:" + m.end());
		}
	}
}

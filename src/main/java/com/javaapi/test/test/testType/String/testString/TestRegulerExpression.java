package com.javaapi.test.test.testType.String.testString;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegulerExpression {

	@Test
	public void test() {
		String specialHint = "未开售:胜平负单关,胜平负过关,半全场胜平负单关,半全场胜平负过关";
		String[] forbiddenLotteryTypes = null;
		if (specialHint.trim().contains("未开")) {
			specialHint = specialHint.trim().replaceAll("未开.*:", "").trim();
			specialHint = specialHint.replaceAll("让球胜平负过关", "4071")
					.replaceAll("比分过关", "4073").replaceAll("总进球数过关", "4072")
					.replaceAll("半全场胜平负过关", "4074").replaceAll("胜平负过关", "4076");
			forbiddenLotteryTypes = specialHint.split(",");
		}
		if (forbiddenLotteryTypes == null) {
			return;
		}
		for (String string : forbiddenLotteryTypes) {
			System.out.println(string);
		}
		List<String> asList = Arrays.asList(forbiddenLotteryTypes);
		System.out.println("-----------");
		System.out.println(asList.contains("4074"));
	}
	@Test
	public void testS() {
        String thisMatchName ="  你  好  "; 
        System.out.println(thisMatchName.replaceAll("\\s*", ""));
        System.out.println("----------");
        System.out.println(StringUtils.deleteWhitespace(thisMatchName));
	}
	@Test
	public void testFenZu() {
		String thisMatchName ="<title>nihao</title><body>nihaoa</body>"; 
		Pattern compile = Pattern.compile("(?<=<title>).*(?=</title>)");
		Matcher matcher = compile.matcher(thisMatchName);
		boolean find = matcher.find();
		int groupCount = matcher.groupCount();
		System.out.println(groupCount);
		System.out.println(matcher.group(0));
		System.out.println(find);
	}
	@Test
	public void testFenZu2() {
		String thisMatchName ="150104001(3-1.2) {4076}"; 
		String regex = "\\{(\\d+)\\}";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(thisMatchName);
		boolean find = matcher.find();
		int groupCount = matcher.groupCount();
		System.out.println(groupCount);
		System.out.println(matcher.group(0));
		System.out.println(matcher.group(1));
		System.out.println(find);
	}

    @Test
    public void testStringFormat() throws Exception {
        String format = "contentToChannel%s";
        Integer number = 11;
        String format1 = String.format(format, number);
        System.out.println("format1 = " + format1);
    }

    @Test
    public void testGroup() {
        String url = "http://www.xxx.com/v/ab123_5";
        Pattern pattern = Pattern.compile("(ab(\\d+)_?(\\d+)?)");
        Matcher m1 = pattern.matcher(url);
        String acpath = null;
        String cid = null;
        String pageNo = null;
        String acpath_2 = null;
        if(m1.find()){
            cid = m1.group(2);
            pageNo = m1.group(3);
            acpath = m1.group(0);
            acpath_2 = m1.group(1);
        }
        System.out.println(cid);
        System.out.println(pageNo);
        System.out.println(acpath);
        System.out.println(acpath_2);
    }

    @Test
	public void testAll(){
		String price = "750.00HBFX160";
		String s = "HB*";

	}
}

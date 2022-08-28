package com.javaapi.test.util.func.poi;

import org.junit.Test;

public class TestAddressUtil {
    @Test
    public void testGetShi() throws Exception {
        String shi = getShi("吉林省四平市铁西区果园街217-3号");
        System.out.println(shi);
        String shi2 = getShi("四平市铁西区果园街217-3号");
        System.out.println(shi2);
    }

    public static String getShi(String addr) throws Exception {
        String str = addr;
        str = str.trim();
		if(str.indexOf("省") >=0 && str.indexOf("市") >=0) {
			int sheng = str.indexOf("省")+1;
			int shi = str.indexOf("市");
			String substring = str.substring(sheng, shi);
			return substring;
		}
		if(str.indexOf("市") >=0) {
			int shi = str.indexOf("市");
			String substring = str.substring(0,shi);
			return substring;
		}
		return null;
	}
	
@Test
public void testRegxAddress() throws Exception {
	String str = " 吉林省四平市铁西区果园街217-3号";
	if(str.indexOf("省") >=0 && str.indexOf("市") >=0) {
		int sheng = str.indexOf("省")+1;
		int shi = str.indexOf("市")+1;
		String substring = str.substring(sheng, shi);
		System.out.println(substring);
	}
}
@Test
public void testRegxAddressShi() throws Exception {
	String str = "四平市铁西区果园街217-3号";
	 str = str.trim();
	if(str.indexOf("市") >=0) {
		int shi = str.indexOf("市")+1;
		String substring = str.substring(0,shi);
		System.out.println(substring);
	}
}
}

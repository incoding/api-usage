package com.javaapi.test.application.safe.xss;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

/**
 * apache commons的处理方式
 */
public class TestXss {
	@Test
	public void testXml() {
		String name = null;
		name="名字<script>alert('a')</script>";
		String after=StringEscapeUtils.escapeXml(name);
		System.out.println(after);
	}
    @Test
    public void testHtml() {
        String name = null;
        name="名字<script>alert('a')</script>";
        String after=StringEscapeUtils.escapeHtml4(name);
        System.out.println(after);
    }
    @Test
    public void testJs() {
        String name = null;
        name="名字<script>alert('a')</script>";
        String after=StringEscapeUtils.escapeEcmaScript(name);
        System.out.println(after);
    }
}

package com.javaapi.test.application.test.testhamcrest;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.Test;

/**http://blog.csdn.net/hanpompy/article/details/7622251
 * http://www.cnblogs.com/zemliu/p/3186557.html
 * http://kinglixing.blog.51cto.com/3421535/748879
 * 
 * 常见漫游匹配器,http://yangzb.iteye.com/blog/299478
 * @author hncw
 *
 */
public class Client {
	@Test
	public void test() throws Exception {
		Integer n = 2;
		String str = "bjsxt";
		assertThat(n , allOf(greaterThan(1), lessThan(15)));
		assertThat(n, anyOf(greaterThan(16), lessThan(8)));
		assertThat(n, anything());
		assertThat(str, is("bjsxt"));
		assertThat(str, not("bjxxt"));
	}
	@Test
	public void test2() throws Exception {
		String str = "bjsxt";
		String n = "";
		String nExpected = "";
		assertThat( str, containsString("bjsxt") );
		assertThat( str, endsWith("bjsxt") );
		assertThat( str, startsWith("bjsxt") );
		assertThat( n, equalTo( nExpected ) ); 
		assertThat( str, equalToIgnoringCase("bjsxt") );
		assertThat( str, equalToIgnoringWhiteSpace("bjsxt") );
	}
	@Test
	public void test3() throws Exception {
		Double d = 3.1d;
		assertThat( d, closeTo( 3.0, 0.3 ) );
		assertThat( d, greaterThan(3.0) );
		assertThat(d, lessThan(10.0));
		 d = 6.1d;
		assertThat( d, greaterThanOrEqualTo(5.0) );
		assertThat( d, lessThanOrEqualTo(16.0) );
	}
	@Test
	public void test4() throws Exception {
		Map<String,String> map =new HashMap<>();
		map.put("bjsxt", "bjsxt");
		assertThat( map, hasEntry( "bjsxt", "bjsxt" ) );
		assertThat( map, hasKey ( "bjsxt" ) );
		assertThat( map, hasValue ( "bjsxt" ) );
	}
	@Test
	public void test5() throws Exception {
        assertThat("t", IsEqual.equalTo("2"));
    }

    public static class IsEqual<T> extends BaseMatcher<T> {
        private final Object expectedValue;

        public IsEqual(T equalArg) {
            expectedValue = equalArg;
        }

        @Override
        public boolean matches(Object actualValue) {
            return areEqual(actualValue, expectedValue);
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(expectedValue);
        }

        private static boolean areEqual(Object actual, Object expected) {
            if (actual == null) {
                return expected == null;
            }

            if (expected != null && isArray(actual)) {
                return isArray(expected) && areArraysEqual(actual, expected);
            }

            return actual.equals(expected);
        }

        private static boolean areArraysEqual(Object actualArray, Object expectedArray) {
            return areArrayLengthsEqual(actualArray, expectedArray) && areArrayElementsEqual(actualArray, expectedArray);
        }

        private static boolean areArrayLengthsEqual(Object actualArray, Object expectedArray) {
            return Array.getLength(actualArray) == Array.getLength(expectedArray);
        }

        private static boolean areArrayElementsEqual(Object actualArray, Object expectedArray) {
            for (int i = 0; i < Array.getLength(actualArray); i++) {
                if (!areEqual(Array.get(actualArray, i), Array.get(expectedArray, i))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isArray(Object o) {
            return o.getClass().isArray();
        }

        @Factory
        public static <T> Matcher<T> equalTo(T operand) {
            return new IsEqual<T>(operand);
        }
    }
}

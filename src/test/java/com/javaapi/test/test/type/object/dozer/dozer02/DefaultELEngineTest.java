package com.javaapi.test.test.type.object.dozer.dozer02;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.github.dozermapper.core.el.DefaultELEngine;
import com.github.dozermapper.core.el.ELEngine;
import com.github.dozermapper.core.el.ELExpressionFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DefaultELEngineTest  {

    protected ELEngine elEngine;
    protected Method method;

    @Before
    public void setUp() throws Exception {

        elEngine = new DefaultELEngine(ELExpressionFactory.newInstance());
        method = DefaultELEngineTest.class.getMethod("concat", String.class, String.class);

        assertNotNull("Failed to getMethod 'concat' from " + DefaultELEngineTest.class.getCanonicalName(), method);
    }

    public static String concat(String a, String b) {
        return a + b;
    }

    @Test
    public void testSimple() {
        elEngine.setVariable("A", "B");

        assertEquals("*B*", elEngine.resolve("*${A}*"));
    }

    @Test
    public void testMap() {
        HashMap<String, Number> hashMap = new HashMap<>();
        hashMap.put("a", 1);

        elEngine.setVariable("A", hashMap, Map.class);

        assertEquals("*1*", elEngine.resolve("*${A['a']}*"));
    }

    @Test
    public void testList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        elEngine.setVariable("a", list);

        assertEquals("*1*", elEngine.resolve("*${a[0]}*"));
    }

    @Test
    public void testTwoExpressions() {
        elEngine.setVariable("A1", "B");
        elEngine.setVariable("A2", "C");

        assertEquals("*B*C*", elEngine.resolve("*${A1}*${A2}*"));
    }

    @Test
    public void testFunction() {
        elEngine.setFunction("dozer", "conc", method);
        elEngine.setVariable("a", "aa");
        elEngine.setVariable("b", "bb");

        String result = elEngine.resolve("${dozer:conc(a,b)}");

        assertEquals("aabb", result);
    }

    @Test
    public void testFunctionDefaultName() {
        elEngine.setFunction("dozer", method);

        String result = elEngine.resolve("${dozer:concat(1,2)}");

        assertEquals("12", result);
    }
}
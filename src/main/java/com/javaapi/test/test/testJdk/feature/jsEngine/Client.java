package com.javaapi.test.test.testJdk.feature.jsEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by user on 16/10/10.
 */
public class Client {
    /**
     * java调用js
     */
    public void testJavaInvokeJs() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        Integer result = null;
        try {
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }
        System.out.println(result.toString());
    }

    /**
     * js调用java
     */
    public void testJsInvokeJava() {

    }
}

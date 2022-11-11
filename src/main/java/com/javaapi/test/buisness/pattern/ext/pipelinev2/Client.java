package com.javaapi.test.buisness.pattern.ext.pipelinev2;

import org.junit.Test;

public class Client {

    @Test
    public void test() {
        Pipeline pipeline = new Pipeline(new IntegerSource());
        pipeline.init(null);
        pipeline.startup();
        pipeline.shutdown();
    }
}

package com.javaapi.test.buisness.pattern.ext.pipeline;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PipelineProxy implements TradePipeline {
    List<TradePipeline> list = new ArrayList<>();
    Iterator<TradePipeline> iterator = null;

    public boolean addPipeline(TradePipeline tradePipeline) {
        return list.add(tradePipeline);
    }

    @Override
    public void filter(OrderContext orderContext, PipelineProxy proxy) {
        if (proxy.iterator == null) {
            proxy.iterator = list.iterator();
        }
        while (proxy.iterator.hasNext()) {
            TradePipeline next = iterator.next();
            next.filter(orderContext, proxy);
        }
    }
}

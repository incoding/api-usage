package com.javaapi.test.spring.spring.pattern.pipelinev2.pipeline;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated

public class PipelineProxy<C> implements TradePipeline<C> {
    List<TradePipeline> list = new ArrayList<>();
    Iterator<TradePipeline> iterator = null;

    @Override
    public void execute(C orderContext, PipelineProxy proxy) {
        if (proxy.iterator == null) {
            proxy.iterator = list.iterator();
        }
        while (proxy.iterator.hasNext()) {
            TradePipeline next = iterator.next();
            next.execute(orderContext, proxy);
        }
    }


    public List<TradePipeline> getList() {
        return list;
    }

    public void setList(List<TradePipeline> list) {
        this.list = list;
    }
}

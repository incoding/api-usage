package com.javaapi.test.application.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * es search
 */
public class EsSearchClient {

    public static final String HOST_1 = "192.168.60.223";
    // esClient内置了线程池
    private Client client;


    @After
    public void destory() {
        client.close();
    }

    @Before
    public void before() {
        Settings settings = Settings.settingsBuilder()
                //注意 要设置集群名字
                .put("cluster.name", "es_cluster")
                        //自动嗅探集群中节点
                .put("client.transport.sniff", true)
                .build();
        try {
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST_1), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearch() {

        BoolQueryBuilder query = boolQuery().should(termQuery("id", "1101")).should(termQuery("id", "1104"));
        SearchResponse response = client.prepareSearch("query_live").setTypes("compere")
                .setQuery(query)
                .execute()
                .actionGet();
        SearchHits hits = response.getHits();
        long totalHits = hits.getTotalHits();
        System.out.println("totalHits = " + totalHits);
        hits.forEach((hit)-> {
            Map<String, Object> source = hit.getSource();
            System.out.println("source = " + source);
        });

    }





}

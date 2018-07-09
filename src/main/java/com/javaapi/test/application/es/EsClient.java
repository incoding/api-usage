package com.javaapi.test.application.es;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.*;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.get.GetResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * es CRUD
 */
public class EsClient {

    public static final String HOST_1 = "localhost";
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
                .put("cluster.name", "myClusterName")
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
    public void index() {
        IndexResponse response = client.prepareIndex("twitter", "tweet","1").setSource(getJson()).get();
        // Index name
        String _index = response.getIndex();
        System.out.println("_index = " + _index);
        // Type name
        String _type = response.getType();
        System.out.println("_type = " + _type);
        // Document ID (generated or not)
        String _id = response.getId();
        System.out.println("_id = " + _id);
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        System.out.println("_version = " + _version);
        // isCreated() is true if the document is a new one, false if it has been updated
        boolean created = response.isCreated();
        System.out.println("created = " + created);
    }

    @Test
    public void update() {
        UpdateResponse updateResponse = client.prepareUpdate("twitter", "tweet", "1").setDoc(getJson2()).get();
        GetResult getResult = updateResponse.getGetResult();
        System.out.println("getResult = " + getResult);
    }

    /**
     * 如果没有则插入
     */
  @Test
    public void upsert() {
      IndexRequest indexRequest = new IndexRequest("twitter", "tweet", "1")
              .source(getJson2());
      UpdateRequest updateRequest = new UpdateRequest("twitter", "tweet", "1")
              .doc(getJson())
              .upsert(indexRequest);
      try {
          client.update(updateRequest).get();
      } catch (InterruptedException e) {
          e.printStackTrace();
      } catch (ExecutionException e) {
          e.printStackTrace();
      }
  }

    @Test
    public void delete() {
        DeleteResponse response = client.prepareDelete("twitter", "tweet", "1").get();
//        如果删除前有数据,则返回true
        System.out.println("response = " +         response.isFound());
    }



    @Test
    public void get() {
        GetResponse response = client.prepareGet("twitter", "tweet", "1")
                .setOperationThreaded(false)
                .get();

        Map<String, Object> source = response.getSource();
        System.out.println("source = " + source);
        System.out.println("version = " + response.getVersion());
    }

    @Test
    public void testMget() throws Exception {
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
                .add("twitter", "tweet", "1")
                .add("twitter", "tweet", "2", "3", "4")
                .get();
        multiGetItemResponses.forEach((resp) -> {
            GetResponse response = resp.getResponse();
            System.out.println("response = " + response.isExists());
            Map<String, Object> source = response.getSource();
            System.out.println("source = " + JSON.toJSONString(source));
        });


    }

    @Test
    public void testBulk() {

        BulkRequestBuilder bulkRequest = client.prepareBulk();

// either use client#prepare, or use Requests# to directly build index/delete requests
        bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")
                        .setSource(getJson2()
                        )
        );

        bulkRequest.add(client.prepareIndex("twitter", "tweet", "2")
                        .setSource(getJson2()
                        )
        );
        bulkRequest.add(client.prepareIndex("twitter", "tweet", "5")
                        .setSource(getJson2()
                        )
        );
        BulkResponse bulkResponse = bulkRequest.get();
        if (bulkResponse.hasFailures()) {
            // process failures by iterating through each bulk response item
            Iterator<BulkItemResponse> iterator = bulkResponse.iterator();
            while (iterator.hasNext()) {
                BulkItemResponse next = iterator.next();
                if (next.isFailed()) {
                    System.out.println(next.getId());
                }
            }
        }
    }

    /**
     *       bulkProcessor 一个就够用了
     * @throws Exception
     */
    @Test
    public void testBulkProcessor() throws Exception {
        BulkProcessor bulkProcessor = BulkProcessor.builder(
                client,
                new BulkProcessor.Listener() {
                    @Override
                    public void beforeBulk(long executionId,
                                           BulkRequest request) {
                    }

                    @Override
                    public void afterBulk(long executionId,
                                          BulkRequest request,
                                          BulkResponse response) {
                    }

                    @Override
                    public void afterBulk(long executionId,
                                          BulkRequest request,
                                          Throwable failure) {
                    }
                })
                .setBulkActions(10000)
//                .setBulkSize(new ByteSizeValue(15, ByteSizeUnit.MB))
                .setFlushInterval(TimeValue.timeValueSeconds(5))
                .setConcurrentRequests(1)
                .build();
        bulkProcessor.add(new IndexRequest("twitter", "tweet", "1").source(getJson()));

//        可以手动flush掉剩余的  或者通过设置     setFlushInterval ,定时来刷,保证有剩余的不被漏下
//        bulkProcessor.flush();

//        bulkProcessor.awaitClose()

    }

    private String getJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", "kimchy");
        map.put("postDate", new Date());
        map.put("message", "trying out Elasticsearch");
        String source = JSON.toJSONString(map);

        return source;
    }
    private String getJson2() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", "kimchy2");
        map.put("postDate", new Date());
        map.put("message", "trying out Elasticsearch");
        String source = JSON.toJSONString(map);

        return source;
    }

}

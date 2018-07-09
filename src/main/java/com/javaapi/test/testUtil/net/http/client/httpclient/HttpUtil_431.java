package com.javaapi.test.testUtil.net.http.client.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/**
 * httpclient 4.3.1 代码
 */
public class HttpUtil_431 {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil_431.class);

    public static <T extends Object> String getUrlParamsByMap(Map<String, T> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = org.apache.commons.lang.StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }

    public static String post(String url, Map<String, String> param) {
        URIBuilder uri = new URIBuilder();
        uri.setPath(url);
        setParams(uri, param);
        CloseableHttpClient client = getClient();
        String result = "";
        try {
            HttpPost post = new HttpPost(uri.build());
            CloseableHttpResponse execute = client.execute(post);
            HttpEntity entity = execute.getEntity();
            if (execute.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 可以忽略证书访问https
     * http://blog.csdn.net/java_4_ever/article/details/47807661
     * http://mengyang.iteye.com/blog/575671(jdk 原生)
     * @return
     */
    private static CloseableHttpClient getClient() {
        //此处跳过证书验证的方式适用于apache httpclient 4.3.x版本，并不一定适用于其他httpclient版本，请注意。
        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    //信任所有
                    return true;
                }
            }).build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());

        Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslConnectionSocketFactory)
                .build();

        //设置连接池，配置过期时间为20s。
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(r);
        cm.setMaxTotal(500);
        cm.setDefaultMaxPerRoute(350);

        SocketConfig socketConfig = SocketConfig.custom()
                .setSoKeepAlive(true)
                .setTcpNoDelay(true)
                .setSoTimeout(20000)
                .build();
        cm.setDefaultSocketConfig(socketConfig);

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000).build();

        //创建httpClient
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .build();
        return client;
    }

    /**
     * url 里不能有参数,否则会有问题
     * @param url
     * @param param
     * @return
     */
    public static String get(String url, Map<String, String> param) {
        URIBuilder uri = new URIBuilder();
        uri.setPath(url);
        setParams(uri, param);
        CloseableHttpClient client = getClient();
        String result = "";
        try {
            HttpGet post = new HttpGet(uri.build());
            CloseableHttpResponse execute = client.execute(post);
            HttpEntity entity = execute.getEntity();
            if (execute.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void setParams(URIBuilder uri, Map<String, String> param) {
        if (param == null) {
            return;
        }
        Iterator<Entry<String, String>> iterator = param.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            uri.setParameter(entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {

        FileBody bin = new FileBody(new File("/Users/user/Downloads/各种视频格式/test.txt"));
        HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).build();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/user/Downloads/各种视频格式/testOutput.txt"));
        reqEntity.writeTo(fileOutputStream);
//        reqEntity.writeTo();

    }

    /**
     * 上传文件
     http://blog.csdn.net/wangpeng047/article/details/19624529
     原理
     http://blog.csdn.net/wangpeng047/article/details/38303865
     */
    public void upload() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceFile.action");

            FileBody bin = new FileBody(new File("F:\\image\\sendpix0.jpg"));
            StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();

            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

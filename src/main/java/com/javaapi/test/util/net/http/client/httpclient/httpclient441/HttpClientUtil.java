package com.javaapi.test.util.net.http.client.httpclient.httpclient441;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

	public static RequestConfig buildConfig(int socketTimeOut,int connectTimeOut,int connectionRequestTimeout){
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeOut)
				.setConnectTimeout(connectTimeOut)
				.setConnectionRequestTimeout(connectionRequestTimeout)
				.build();
		return defaultRequestConfig;
	}

	public static RequestConfig buildConfig(int socketTimeOut,int connectTimeOut){
		return buildConfig(socketTimeOut,connectTimeOut,connectTimeOut);
	}
	public static RequestConfig defaultConfig(){
		return buildConfig(5000,5000);
	}

	public static String doGet(String url, Map<String, String> param,RequestConfig config) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		HttpGet httpGet = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			httpGet = new HttpGet(uri);
			//设置超时时间
			if(config==null){
				httpGet.setConfig(defaultConfig());
			}else{
				httpGet.setConfig(config);
			}

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(httpclient, response, httpGet);
		}
		return resultString;
	}



	public static String doGet(String url,RequestConfig config) {
		return doGet(url, null,config);
	}

	public static String doGet(String url) {
		return doGet(url, null,null);
	}
	public static String doGet(String url, Map<String, String> map) {
		return doGet(url, map,null);
	}

	public static String doPost(String url, Map<String, String> param,RequestConfig config) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		HttpPost httpPost = null;
		try {
			// 创建Http Post请求
			httpPost = new HttpPost(url);
			if(config==null){
				config = defaultConfig();
			}
			httpPost.setConfig(config);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(httpClient, response, httpPost);
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null,null);
	}

	public static String doPostJson(String url, String json,RequestConfig config) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		HttpPost httpPost = null;
		try {
			// 创建Http Post请求
			httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			if(config==null){
				config = defaultConfig();
			}
			httpPost.setConfig(config);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(httpClient, response, httpPost);
		}

		return resultString;
	}

	private static void close(CloseableHttpClient httpClient, CloseableHttpResponse response, HttpRequestBase httpPost) {
		try {
			if(response!=null){
				response.close();
			}
            if(httpPost!=null){
                httpPost.abort();
            }
			if(httpClient!=null){
				httpClient.close();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
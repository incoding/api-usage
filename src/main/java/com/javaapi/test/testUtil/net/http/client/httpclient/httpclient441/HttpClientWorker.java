package com.javaapi.test.testUtil.net.http.client.httpclient.httpclient441;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.*;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpClientWorker {
	private static final Logger log = LoggerFactory
			.getLogger(HttpClientWorker.class);

	private static final CloseableHttpClient HTTP_CLIENT;

	private static final int CONNECTION_MAX_TOTAL = 1200;

	private static final int MAX_PER_ROUTE = 600;

	public static final int OK = 200;

	/**
	 * 自定义HTTP状态-连接超时
	 */
	public static final int STATUS_CODE_TIMEOUT = 600;
	/**
	 * 自定义HTT状态-其它错误
	 */
	public static final int STATUS_CODE_OTHER = 603;

	private String charset = "UTF-8"; // 默认字符编码

	private int connectionRequestTimeout = 30000;

	private int connectTimeout = 30000;

	private int socketTimeOut = 30000;
	
	private static final int RETRY_CNT = 1;//重试3次

	private List<Header> headers = new ArrayList<Header>();
	
	private HttpClientContext context = HttpClientContext.create();

	static {
		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
				.getSocketFactory();
		LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory
				.getSocketFactory();
		Registry<ConnectionSocketFactory> registry = RegistryBuilder
				.<ConnectionSocketFactory> create().register("http", plainsf)
				.register("https", sslsf).build();

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
				registry);
		// 将最大连接数增加到200
		cm.setMaxTotal(CONNECTION_MAX_TOTAL);
		// 将每个路由基础的连接增加到20
		cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
		cm.setValidateAfterInactivity(1000);
		ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response,
					HttpContext context) {
				// Honor 'keep-alive' header
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));

				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (NumberUtils.isDigits(value) && param.equalsIgnoreCase("timeout")) {
						return NumberUtils.toLong(value,10)*1000L;
					}
				}
				// HttpHost target = (HttpHost)
				// context.getAttribute(HttpCoreContext.HTTP_TARGET_HOST);
				// if ("www.elong.com".equalsIgnoreCase(target.getHostName())) 
				// return 5 * 1000;路由的连接，保持5秒

				return 30 * 1000;
			}
		};
		HTTP_CLIENT = HttpClients
				.custom()
				.setConnectionManager(cm)
				.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)) // 请求重试处理
				.setKeepAliveStrategy(keepAliveStrategy)
				.setUserAgent(
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.204 Safari/534.16")
				.build();
		IdleConnectionMonitorThread idleConnectionMonitorThread = new IdleConnectionMonitorThread(
				cm);
		idleConnectionMonitorThread.setDaemon(true);
		idleConnectionMonitorThread.setName("IdleConnectionMonitorThread");
		idleConnectionMonitorThread.start();
	}

	/**
	 * get方式 如果没有超时时间进行限制，则采用默认的超时时间
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public HttpResult get(String url, List<NameValuePair> params) {
		return httpExe(getHttpGet(url, params));
	}

	protected HttpGet getHttpGet(String url, List<NameValuePair> params) {
		String requestUrl = null;
		if (params != null && !params.isEmpty()) {
			String paramStr = URLEncodedUtils.format(params, charset);
			StringBuffer buffer = new StringBuffer(url);
			if (StringUtils.containsNone(url, "?")) {
				buffer.append("?");
			}
			buffer.append(paramStr);
			requestUrl = buffer.toString();
		} else {
			requestUrl = url;
		}

		return new HttpGet(requestUrl);
	}

	/**
	 * post方式 如果没有超时时间进行限制，则采用默认的超时时间
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public HttpResult post(String url, List<NameValuePair> params) {
		return httpExe(getHttpPost(url, params));
	}

	public HttpResult post(String url, String content) {
		return httpExe(getHttpPost(url, content));
	}
	
	public HttpResult post(String url, byte[] content) {
		return httpExe(getHttpPostByte(url, content));
	}

	protected HttpPost getHttpPost(String url, List<NameValuePair> params) {
		HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(params, charset));
			return post;
		} catch (Exception e) {
			log.error("getHttpPost Exception", e);
		}
		return null;
	}

	protected HttpPost getHttpPost(String url, String content) {
		HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new StringEntity(content, charset));
		} catch (Exception e) {
			log.error("getHttpPost Exception", e);
		}
		return post;

	}
	
	protected HttpPost getHttpPostByte(String url, byte[] content) {
		HttpPost post = new HttpPost(url);
		try {
			
			post.setEntity(new ByteArrayEntity(content));
			
		} catch (Exception e) {
			log.error("getHttpPost Exception", e);
		}
		return post;

	}
	
	
	private void buildRequestConfig(HttpRequestBase request) {
		if (headers != null && headers.size() > 0) {
			for (Header header : headers) {
				if (header != null) {
					request.addHeader(header);
				}
			}
		}

		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(connectionRequestTimeout)
				.setConnectTimeout(connectTimeout)
				.setSocketTimeout(socketTimeOut).build();
		request.setConfig(requestConfig);
		request.setProtocolVersion(HttpVersion.HTTP_1_1);

	}

	public HttpResult httpExe(HttpRequestBase request) {
		HttpResult result = new HttpResult();
		result.setStatusCode(STATUS_CODE_TIMEOUT);
		for (int retryCnt = 0; STATUS_CODE_TIMEOUT == result.getStatusCode() && retryCnt < RETRY_CNT; retryCnt++) {
		CloseableHttpResponse response = null;
		try {
			buildRequestConfig(request);
			response = HTTP_CLIENT.execute(request,this.context);
			StatusLine status = response.getStatusLine();
			result.setHeaders(response.getAllHeaders());
			result.setStatusCode(status.getStatusCode());
//			entity = response.getEntity();
			if (status != null && status.getStatusCode() == OK) {
				result.setContent(EntityUtils.toString(response.getEntity(),this.charset));
			} else {
				result.setContent(StringUtils.EMPTY);
			}
			EntityUtils.consume(response.getEntity());
		} catch (SocketTimeoutException e) {
			request.abort();
			result.setStatusCode(STATUS_CODE_TIMEOUT);
			log.error("httpExe SocketTimeoutException", e);
		} catch (ConnectTimeoutException e) {
			request.abort();
			result.setStatusCode(STATUS_CODE_TIMEOUT);
			log.error("httpExe ConnectTimeoutException", e);
		} catch (Exception e) {
			request.abort();
			result.setStatusCode(STATUS_CODE_OTHER);
			log.error("httpExe Exception", e);
		} finally {
			if (request != null) {
				request.releaseConnection();
			}
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					log.error("httpExe response.close IOException", e);
				}
			}
		}
		}
		return result;
	}

	public void setRequestConfig(int connectionRequestTimeout,
			int connectTimeout, int socketTimeOut) {
		if (connectionRequestTimeout > 0) {
			this.connectionRequestTimeout = connectionRequestTimeout;
		}
		if (connectTimeout > 0) {
			this.connectTimeout = connectTimeout;
		}
		if (socketTimeOut > 0) {
			this.socketTimeOut = socketTimeOut;
		}

	}
	
	public void addUserOAuth(String username,String password){

		CredentialsProvider  credsProvider = new BasicCredentialsProvider();
		org.apache.http.auth.Credentials credentials = new org.apache.http.auth.UsernamePasswordCredentials(username,password);
		credsProvider.setCredentials(org.apache.http.auth.AuthScope.ANY,credentials);
		this.context.setCredentialsProvider(credsProvider);
	}
	
	public void addHeader(String name, String value) {
		if (StringUtils.isNotBlank(name)) {
			headers.add(new BasicHeader(name, value));
		}

	}

	public void setCharset(String charset) {
		if(StringUtils.isNotBlank(charset)){
			this.charset = charset;
		}
		
	}

	public class HttpResult {
		private Header[] headers;
		private String content;
		private int statusCode = 200;

		public Header[] getHeaders() {
			return headers;
		}

		public void setHeaders(Header[] headers) {
			this.headers = headers;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
	}

	public static class IdleConnectionMonitorThread extends Thread {
		private final PoolingHttpClientConnectionManager connMgr;
		private volatile boolean shutdown;

		public IdleConnectionMonitorThread(
				PoolingHttpClientConnectionManager connMgr) {
			super();
			this.connMgr = connMgr;
		}

		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// 关闭过期的连接
						connMgr.closeExpiredConnections();
						// 关闭空闲时间超过30秒的连接
						connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
				log.error(
						"IdleConnectionMonitorThread run InterruptedException",
						ex);
			}
		}

		public void shutdown() {
			shutdown = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}
}

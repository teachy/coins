package com.teachy.coins.dd;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import com.teachy.coins.utils.StringUtils;

/**
 * 19d
 */
@Component
public class DDTasks {
	public static HttpClient httpClient;
	private static HttpResponse response;
	private static PoolingHttpClientConnectionManager connectionManager;
	private static RequestConfig requestConfig;
	private static String DOMAIN = "http://www.game3799.com";

	static {
		Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
			.register("http", PlainConnectionSocketFactory.INSTANCE)
			.register("https", SSLConnectionSocketFactory.getSocketFactory())
			.build();
		connectionManager = new PoolingHttpClientConnectionManager(reg);
		connectionManager.setMaxTotal(50);
		connectionManager.setDefaultMaxPerRoute(10);
		requestConfig = RequestConfig.custom()
			.setConnectTimeout(5000).setConnectionRequestTimeout(2000)
			.setSocketTimeout(5000).build();
		httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();
	}

	public static void login(String name, String password, String code) throws IOException {
		if(getIdAndGold().contains("null")){
			HttpPost loginPost = new HttpPost(DOMAIN + "/Account/HomeLogon");
			List<BasicNameValuePair> formParams = new ArrayList<>();
			formParams.add(new BasicNameValuePair("UserName", name));
			formParams.add(new BasicNameValuePair("Password", password));
			formParams.add(new BasicNameValuePair("VCode", code));
			loginPost.setEntity(new UrlEncodedFormEntity(formParams, "utf-8"));
			loginPost.addHeader("Origin", DOMAIN);
			loginPost.addHeader("Referer", DOMAIN);
			response = httpClient.execute(loginPost);
			getAllContent(response);
		}
	}

	public static String getIdAndGold() throws IOException {
		HttpGet get = new HttpGet(DOMAIN);
		get.setConfig(requestConfig);
		HttpResponse response = httpClient.execute(get);
		String tem = getAllContent(response);
		String id = StringUtils.getRegexStr(tem, "ID：(\\d+)");
		String num = StringUtils.getRegexStr(tem, "</a>金豆：(.*?)<span ");
		return "123456" + ":" + num;
	}

	public static String getAllContent(HttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		InputStream is = null;
		String responseData;
		try {
			is = entity.getContent();
			responseData = IOUtils.toString(is, "UTF-8");
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return responseData;
	}

	public static InputStream GetVerificationCode() throws IOException {
		HttpGet imgGet = new HttpGet(DOMAIN + "/Common/VCode?" + Math.random() * 1000);
		return httpClient.execute(imgGet).getEntity().getContent();
	}
}

package com.teachy.coins.macdandkdj;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.UrlUtils;

public class ClientMethodUtils {
	private final static Logger logger = LoggerFactory.getLogger(ClientMethodUtils.class);
	private static final String DefaultCharSet = "utf-8";
    
	/**
	 * 给post或者get添加header参数的泛型方法
	 * 
	 * @param c
	 *            HttpPost/HttpGet对象
	 * @param map
	 *            存放header的key-value的Map
	 * @return
	 * @throws Exception
	 * @throws InstantiationException
	 */
	public static <T extends HttpRequestBase> T addHeader(T t, Map<String, String> map) {
		if (t != null && map != null && map.size() > 0) {
			Iterator<Entry<String, String>> iterable = map.entrySet().iterator();
			while (iterable.hasNext()) {
				try {
					Entry<String, String> entry = iterable.next();
					t.setHeader(entry.getKey(), entry.getValue());
				} catch (Exception e) {
					logger.error("HttpRequestBase Add Params Error!",e.getMessage());
					e.printStackTrace();
				}
			}
		} else {
			logger.error("参数或对象为null");
		}
		return t;
	}

	/**
	 * 给post方法添加参数
	 * 
	 * @param post
	 * @param paramsMap
	 * @param charSet
	 * @return
	 */
	public static HttpPost addPostWithParams(HttpPost post, Map<String, String> paramsMap, String charSet) {
		if (post != null && paramsMap != null && paramsMap.size() > 0) {
			List<BasicNameValuePair> nvps = new ArrayList<>();
			Iterator<Entry<String, String>> iterator = paramsMap.entrySet().iterator();
			try {
				while (iterator.hasNext()) {
					Entry<String, String> entry = iterator.next();
					String key = entry.getKey();
					String value = entry.getValue();
					if (key != null) {
						nvps.add(new BasicNameValuePair(key, value == null ? "" : value));
					} else {
						continue;
					}
				}
				post.setEntity(new UrlEncodedFormEntity(nvps, charSet));
			} catch (Exception e) {
				logger.error("Add Params Error!");
			}
		} else {
			logger.error("Params Is Illegal!");
		}
		return post;
	}
	
	/**
	 * 从页面中解析字体编码
	 * @param htmlPage
	 * @return
	 */
	private static String getCharSet(final String htmlPage) {
		String regex1 = "<meta.*charset=([^;^\"]*).*";
		String value1 = StringUtil.getRegexStr(htmlPage, regex1);
		if (StringUtils.isNotBlank(value1)) {
			return value1;
		}
		return null;
	}
	
	/**
	 * 从ResponseHeader头中读取字体编码
	 * @param response
	 * @return
	 */
	public static String charSet(final CloseableHttpResponse response){
		String charSet = null;
		if (response != null) {
			Header[] headers = response.getHeaders("Content-Type");
			String regex = "charset=([\\s\\S]*?);{0,1}";
			Pattern pattern = Pattern.compile(regex);
			for (Header header : headers) {
				String value = header.getValue().toLowerCase();
				Matcher matcher = pattern.matcher(value);
				while (matcher.find()) {
					charSet = matcher.group(1);
					return charSet;
				}
			}
		}
		return charSet;
	}
	
	/**
	 * 
	 * @param client
	 * @param httpRequestBase
	 * @param charSet
	 * @return
	 */
	public static String getContent(CloseableHttpClient client, HttpRequestBase httpRequestBase) {
		String pageContent = "";
		if (client != null && httpRequestBase != null) {
			try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
				CloseableHttpResponse response = client.execute(httpRequestBase);
				IOUtils.copy(response.getEntity().getContent(), baos);
				InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
				InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
				String htmlPage = IOUtils.toString(stream1);
				String charSet = charSet(response);
				if (StringUtils.isBlank(charSet)) {
					charSet = getCharSet(htmlPage);
				}
				//未解析到字体编码，使用默认的字体编码
				pageContent = IOUtils.toString(stream2, StringUtils.isNotBlank(charSet) ? charSet : DefaultCharSet);
				response.getEntity().getContent().close();
				EntityUtils.consume(response.getEntity());
				response.close();
				httpRequestBase.abort();
				stream1.close();
				stream2.close();
				stream1 = null;
				stream2 = null;
			} catch (Exception e) {
				logger.error("HttpRequestBase Add Params Error!",e.getMessage());
				e.printStackTrace();
			}finally {
				
			}
		} else {
			logger.error("Params Is Illegal!");
		}
		return pageContent;
	}

	/**
	 * 得到验证码图片
	 * 
	 * @param client
	 * @param url
	 * @return
	 */
	public static BufferedImage getImageByNet(CloseableHttpClient client, String url, String filePath) {
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response;
		BufferedImage image = null;
		try {
			response = client.execute(get);
			InputStream is = response.getEntity().getContent();
			File f = new File(filePath);
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			response.close();
			get.abort();
			fos.close();
			image = ImageIO.read(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static HttpResponse getResponse(HttpClient client, HttpRequestBase httpRequestBase) throws Exception {
			return client.execute(httpRequestBase);
	}

    /**
     * 
     * 〈获取html〉
     * 
     * @param Content
     * @param url
     */
    public static Html getHtml(String Content, String url)
        throws IOException {
        return new Html(UrlUtils.fixAllRelativeHrefs(Content, url));
    }
}
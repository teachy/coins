package com.teachy.coins.macdandkdj;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName: HttpPoolUtil
 * @Description:
 * @date 2018年5月7日 下午12:45:09
 */
public class HttpPoolUtil {
    public static RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).setRedirectsEnabled(false)
            .setConnectTimeout(HttpClientConstant.CONNECTTIMEOUT)
            .setConnectionRequestTimeout(HttpClientConstant.CONNECTTIMEOUT)
            .setSocketTimeout(HttpClientConstant.SOCKETTIMEOUT)
            .build();
    private static PoolingHttpClientConnectionManager connectionManager;
    private static Map<String, CloseableHttpClient> clients = new HashMap<String, CloseableHttpClient>();

    static {
        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        connectionManager = new PoolingHttpClientConnectionManager(reg);
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(20);
    }

    public static CloseableHttpClient getClient(String name) {
        if (clients.get(name) == null) {
            clients.put(name, HttpClientBuilder.create().setConnectionManager(connectionManager).build());
        }
        return clients.get(name);
    }

}

package com.teachy.coins;

import com.teachy.coins.gateio.restApi.IStockRestApi;
import com.teachy.coins.gateio.restApi.impl.StockRestApiImpl;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinsApplicationTests {

    private final static String query_url = "http://data.gateio.io";

    private static IStockRestApi stockGet = new StockRestApiImpl(query_url);
    public static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    @Ignore
    @Test
    public void contextLoads() {
        try {
            String res = stockGet.pairs();
            System.out.println(res);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void tt() {
        HttpClient client = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet("http://data.gateio.co/api2/1/pairs");
        try {
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
            httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            httpGet.addHeader("Accept-Encoding", "gzip, deflate");
            httpGet.addHeader("Host", "data.gateio.io");
            httpGet.addHeader("Upgrade-Insecure-Requests", "1");
            httpGet.addHeader("Accept-Encoding", "gzip, deflate, br");
            httpGet.addHeader("Cache-Control", "0");
            httpGet.addHeader("Connection", "keep-alive");
            httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

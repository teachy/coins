package com.teachy.coins;

import java.io.IOException;

import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.teachy.coins.gateio.restApi.IStockRestApi;
import com.teachy.coins.gateio.restApi.impl.StockRestApiImpl;

@SpringBootApplication
@EnableScheduling
public class CoinsApplication extends SpringBootServletInitializer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(CoinsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CoinsApplication.class);
	}

	@Scheduled(cron = "0/10 * * * * ?")
	private void test(){
		String query_url = "https://data.gateio.io";
		String trade_url = "https://api.gateio.io";


		IStockRestApi stockGet = new StockRestApiImpl(query_url);

		IStockRestApi stockPost = new StockRestApiImpl(trade_url);

		// All trading Pairs
		String pairs = null;
		try {
			pairs = stockGet.candlestick2("eth","usdt",60,1);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pairs);
	}
}

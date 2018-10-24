package com.teachy.coins.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@PropertySource(value = "classpath:email.properties")
public class SendEmail {
	@Value("${email.host}")
	private  String host;
	@Value("${email.userName}")
	private  String userName;
	@Value("${email.password}")
	private  String password;
	@Value("${email.sendto}")
	private  String sendto;

	public  void sendEmail(String title, String content) {
		EmailUtil mail = new EmailUtil();
		mail.setHost(host);
		mail.setUserName(userName);
		mail.setPassword(password);
		mail.setSendTo(sendto);
		String[] address = null;
		try {
			mail.send(address, sendto, title, content);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}

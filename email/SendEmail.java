package com.tu.utils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.dom4j.DocumentException;

public class SendEmail {

	public static void sendEmail(String title,String content){
		String host = "smtp.126.com";    // 发送邮件的服务器
		String userName = "teachyy@126.com";  // 可替换为你自己的邮箱用户名    
		String password = "tu19891113";  // 邮箱密码
		String sendto = "306056969@qq.com"; //送给哪些邮箱地址
		MailUtil mail=new MailUtil();
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

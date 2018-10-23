package com.tu.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.dom4j.DocumentException;


import sun.misc.BASE64Encoder;

public class MailUtil {

    private String host;                            // 发送邮件的服务器
    private String userName;                        // 可替换为你自己的邮箱用户名    
    private String password ;                        // 邮箱密码
    private String sendTo ;                              // 你要发送的邮箱名称    
    private String errMsg;                          // 错误信息
    private List arrFileName=new ArrayList();            // 用于保存发送附件的文件名列表    
    
    /**
     * @发送邮件
     * @param address 附件地址
     * @param toes    接收者的邮箱地址（多个的话用逗号分隔）
     * @param subject    主题
     * @param content    内容
     * @throws MalformedURLException
     * @throws DocumentException
     * @throws UnsupportedEncodingException 
     */
    public boolean send(String[] address,String toes,String subject,String content) throws MalformedURLException, DocumentException, UnsupportedEncodingException{
        if(address != null){    // 有附件的邮件，添加邮件
            for(String s : address){
                if(s != null && !"".equals(s)){
                    this.attachFile(s);
                }
            }
        }
        // 发送邮件
        return this.sendMail(toes, subject, content);
    }

    /**
     * @发送邮件的方法
     * @param to：发送给哪些邮箱地址
     * @param subject: 邮件主题 
     * @param content：邮件内容
     * @return 发送是否成功
     * @throws MalformedURLException
     * @throws DocumentException
     * @throws UnsupportedEncodingException 
     */
    public boolean sendMail(String to, String subject, String content) throws UnsupportedEncodingException {
        Properties props = System.getProperties();                    // 创建Properties对象
        props.put("mail.smtp.host", this.host);                        // 创建信件服务器，如：props.put("mail.smtp.host", "smtp.163.com");  
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");                         // 通过验证  
        props.put("mail.smtp.localhost", "localHostAddress");
        MyAuthenticator authenticator = new MyAuthenticator(this.getUserName(),this.getPassword());
 
        Session session = Session.getDefaultInstance(props, authenticator);    // 得到默认的对话对象
        Transport transport =null;
        boolean conn = false;
		try {
			 transport = session.getTransport("smtp");
			 transport.connect(host, this.getUserName(),this.getPassword());
			 conn=transport.isConnected();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		if(!conn){
			return false;
		}else{
		
	        try {   
	            // 根据session创建一个邮件消息   
	            Message mailMessage = new MimeMessage(session);   
	            // 创建邮件发送者地址   
	            Address from = new InternetAddress(this.getUserName());   
	            // 设置邮件消息的发送者   
	            mailMessage.setFrom(from);   
	            // 创建邮件的接收者地址，并设置到邮件消息中   
	            if (to.trim().length() > 0) {
	                String[] arr = to.split(";");
	                int receiverCount = arr.length;    // 接收邮件的人数
	                if (receiverCount > 0) {           // 有接收者
	                    InternetAddress[] address = new InternetAddress[receiverCount];    // 创建接收者网络地址
	                    for (int i = 0; i < receiverCount; i++) {
	                        address[i] = new InternetAddress(arr[i]);
	                    }
	                    mailMessage.addRecipients(Message.RecipientType.TO, address);
	                }else{    // 没有接收者的话将退出
	                	this.errMsg = "没有接收者!";
	                	return false;
	                }
	            } else {    // 没有接收者的话将退出
	            	this.errMsg = "没有接收者!";
	            	return false;
	            }
	            // 设置邮件消息的主题   
	            mailMessage.setSubject(subject);   
	            // 设置邮件消息发送的时间   
	            mailMessage.setSentDate(new Date());   
	            // 设置邮件消息的主要内容
	            Multipart mp = new MimeMultipart();                            // 后面的BodyPart将加入到此处创建的Multipart中
	            // 获取附件            
	            int FileCount = this.arrFileName.size();                    // 附件数
	            if (FileCount > 0) {
	                // 添加邮件正文内容
	                MimeBodyPart mbpb = new MimeBodyPart(); 
	                mbpb.setText(content, "UTF-8");                         // 设置邮件正文，注意编码
	                mp.addBodyPart(mbpb); 
	                BASE64Encoder enc = new BASE64Encoder();                // 用于转码
	                // 处理邮件附件
	                for (int i = 0; i < FileCount; i++) {
	                    MimeBodyPart mbp = new MimeBodyPart();
	                    String fileName = arrFileName.get(i).toString();            // 选择出附件名
	                    FileDataSource fds = new FileDataSource(fileName);    // 得到数据源 
	                    mbp.setDataHandler(new DataHandler(fds));            // 得到附件本身并至入BodyPart
	                    mbp.setFileName("=?UTF-8?B?"+enc.encode(fds.getName().getBytes("UTF-8"))+"?=");
	                    mp.addBodyPart(mbp);
	                }
	                arrFileName = null;                    // 移走集合中的所有元素
	                mailMessage.setContent(mp);            // Multipart加入到信件  
	            }else {
	            	mailMessage.setText(content);          // 设置邮件正文，注意编码
	            }
	            // 发送邮件   
	            Transport.send(mailMessage); 
	            transport.close();
	            return true;   
	        } catch (MessagingException ex) { 
	        	ex.printStackTrace();
	        	this.errMsg = "邮件发送异常:" + ex.getMessage() + "!";
	        	return false;
	        } 
    	
		}
    }
    
    /**
     * @获得错误信息
     * @return String 错误信息
     */
    public String getErrMsg(){
        return errMsg;
    }

    // 用于收集附件名    
    public void attachFile(String fileName) {
        this.arrFileName.add(fileName);
    }
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public List getArrFileName() {
        return arrFileName;
    }

    public void setArrFileName(List arrFileName) {
        this.arrFileName = arrFileName;
    }
    
    public class MyAuthenticator extends Authenticator{  
        String userName=null;  
        String password=null;  
    
        public MyAuthenticator(){  
        }  
        public MyAuthenticator(String username, String password) {   
            this.userName = username;   
            this.password = password;   
        }   
        protected PasswordAuthentication getPasswordAuthentication(){  
        	return new PasswordAuthentication(userName, password);  
        }  
    } 
}

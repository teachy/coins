package com.teachy.coins.dd;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * limit
 */
@Component
@EnableAsync
public class TzTask4zuhe {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static List<Integer> jgListforJS = new ArrayList<>();
    private static List<Integer> jgListforFK = new ArrayList<>();
    private static List<Integer> jgListforJSLast = new ArrayList<>();
    private static List<Integer> jgListforFKLast = new ArrayList<>();
    static HttpGet kfget = new HttpGet("http://www.game3799.com/Crazy28/index");
    static HttpGet jsget = new HttpGet("http://www.game3799.com/Speed28/index");
    static HttpPost postFK = new HttpPost("http://www.game3799.com/Crazy28/Bet");
    static HttpPost postJS = new HttpPost("http://www.game3799.com/Speed28/Bet");
    private int bsJS = 1;
    private int bsFK = 1;
    //FK 11:0.82
    //JS 11:0.82
    private int beeting = 288888;
    private int beeting1 = 388888;
    private double fkxs = 1.1;
    private double jsxs = 1.1;
    private int jsMax = 6;
    private int jsMax_jiange = 4;
    private int fkMax = 6;
    private int fkMax_jiange = 4;
    @Autowired
    private DDSprider dDSprider;
    @Autowired
    private SFTest sfTest;

    @Async
    @Scheduled(cron = "1 0/1 * * * ?")
    public void tzForFK() {
        try {
            if (!DDTasks.getIdAndGold().contains("null")) {
                fkff();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Async
    @Scheduled(cron = "49 0/1 * * * ?")
    public void tzForJS() {
        try {
            if (!DDTasks.getIdAndGold().contains("null")) {
                jsff();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Async
    @Scheduled(cron = "5 0/30 * * * ?")
    public void modifyCookie() {
        try {
            DDTasks.getIdAndGold();
        } catch (Exception e) {

        }
    }

    private void jsff() throws IOException, InterruptedException {
        DD dd = dDSprider.get28(jsget);
        if (Integer.parseInt(dd.getJcTime()) > 10) {
            jgListforJS = dDSprider.getListbyDBLimit("JS", jsxs, 250);
            if (jgListforJS.size() > 2) {
                int sleepTime = (int) (Math.random() * Integer.parseInt(dd.getJcTime()));
                Thread.sleep(sleepTime * 1000);
                if (jgListforJSLast.contains(dd.jieguo)) {
                    bsJS = 1;
                } else {
                    if (bsJS < jsMax) {
                        bsJS++;
                    }
                }
                if (Times.getCheckTime()) {
                    if (bsJS >= jsMax_jiange) {
                        dDSprider.tz28(dd, beeting * bsJS, postJS, jgListforJS);
                    }
                }
                jgListforJSLast.clear();
                jgListforJSLast.addAll(jgListforJS);
                int sleep1 = (Integer.parseInt(dd.getKjTime()) - sleepTime);
                Thread.sleep(sleep1 * 1000);
            }
        }
    }

    private void fkff() throws IOException, InterruptedException {
        DD dd = dDSprider.get28(kfget);
        if (Integer.parseInt(dd.getJcTime()) > 10) {
            jgListforFK = dDSprider.getListbyDBLimit("FK", fkxs, 200);
            if (jgListforFK.size() > 2) {
                int sleepTime = (int) (Math.random() * Integer.parseInt(dd.getJcTime()));
                Thread.sleep(sleepTime * 1000);
                if (jgListforFKLast.contains(dd.jieguo)) {
                    bsFK = 1;
                } else {
                    if (bsFK < fkMax) {
                        bsFK++;
                    }
                }
                if (Times.getCheckTime()) {
                    if (bsFK >= fkMax_jiange) {
                        dDSprider.tz28(dd, beeting * bsFK, postFK, jgListforFK);
                    }
                }
                jgListforFKLast.clear();
                jgListforFKLast.addAll(jgListforFK);
                int sleep1 = (Integer.parseInt(dd.getKjTime()) - sleepTime);
                Thread.sleep(sleep1 * 1000);
            }
        }
    }
}

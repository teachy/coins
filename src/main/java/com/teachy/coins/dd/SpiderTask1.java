package com.teachy.coins.dd;

import com.teachy.coins.mapper.Dd3799DDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

//@Component
public class SpiderTask1 {

    static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
            0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
    static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
            75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
    List<Integer> allres = new ArrayList<>();
    int getCount = 0;
    double test = 0.80;
    int test1 = 2;
    @Autowired
    private Dd3799DDAO dd3799DDAO;
    int max1 = 1;
    int max2 = 1;
    int maxday = 3;//2018-11-11
    int beginNum = 200;

    //FK 350:11:0.82
    //JS 1050:11:0.86

    //备选：FK:850，5，0.92--1000，3，0.98
    //备选：JS:250，8,0.81--350,11,0.82--450,5,0.90--650,6,0.8
    @Scheduled(cron = "0/1 * * * * ?")
    public void getHistory1() {
        allres = dd3799DDAO.getAllListByType("FK");
        for (int beginNum = 200; beginNum <= 200; beginNum = beginNum + 50) {
            for (int k = 6; k <= 6; k++) {
                for (double t = 1.1; t <= 1.1; t = t + 0.01) {
                    for(int m=1;m<=3;m++){
                        List<Integer> begin = allres.stream().limit(beginNum).collect(toList());
                        List<Integer> after = allres.stream().skip(beginNum).collect(toList());
                        int bs = 1;
                        int temcout = 0;
                        int tem;
                        int jishuqi=0;
                        int jishuqicount=0;
                        for (Integer integer : after) {
                            jishuqi++;
                            List<Integer> tz = getTZ(begin, t);
                            tem = tz.stream().mapToInt(e -> bet[e]).sum();
                            if (max1 > max2) {
                                max2 = max1;
                            }
//                            System.out.println(tz);
                            if (tz.contains(integer)) {
                                if(bs>=m){
                                    temcout = temcout - tem * bs + 990 * bs;
                                jishuqicount = jishuqicount - tem * bs + 990 * bs;
                                }
                                bs = 1;
                                max1 = 1;
                            } else {
                                max1++;
                                if(bs>=m){
                                    temcout = temcout - tem * bs;
                                jishuqicount = jishuqicount - tem * bs;
                                }
                                if (bs < k) {
                                    bs++;
                                }
                            }
                            begin.remove(0);
                            begin.add(integer);
                            if(jishuqi>500){
//                                System.out.println("jishuqicount" + ":" + jishuqicount);
                                jishuqicount=0;
                            }
                        }
//                    if(temcout>80000)
                        System.out.println(temcout + ":" + beginNum + ":" + k + ":" + "max1:"+max2);
                    }
                }
            }
        }
    }

    private List<Integer> getTZ(List<Integer> begin, double test) {
        List<Integer> tz = new ArrayList<>();
        for (int i = 0; i <= 27; i++) {
            int[] count = new int[28];
            begin.stream().forEach(e -> count[e]++);
            double temd = ((double) count[i] / begin.size()) / jg[i > 13 ? 27 - i : i];
            BigDecimal b = new BigDecimal(temd);
            temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (temd < test) {
                if (i > 2 && i < 25) {
                    tz.add(i);
                }
            }
        }
        return tz;
    }

}

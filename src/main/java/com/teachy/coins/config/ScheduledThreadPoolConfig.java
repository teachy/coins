package com.teachy.coins.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @author gang.tu
 * @ClassName ScheduledThreadPoolConfig
 * @Description
 * @Date 2019/9/19 17:17
 */
@Configuration
public class ScheduledThreadPoolConfig implements SchedulingConfigurer {

    @Value("4")
    private int corePoolSize;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(corePoolSize));
    }
}
package com.mikael.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.TimeUnit;

/**
 * @description:动态cron
 * @author: mikael
 * @data: 2020/11/12
 */
@Configuration
public class ScheduleConfig2 implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        String cron1 = "*/10 * * * * *";
        String cron2 = "*/13 * * * * *";
        taskRegistrar.addCronTask(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("动态cron1\t");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, cron1);
        taskRegistrar.addCronTask(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("动态cron2\t");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, cron2);
    }
}

package com.mikael.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @description: 写死的cron时间
 * @author: mikael
 * @data: 2020/11/12
 */
@Component
public class ScheduleConfig {
    /**
     * cron 可以有其他的类型来实现不同的情况
     */
    @Scheduled(cron = "*/10 * * * * *")
    public void test() {
        System.out.println("按 cron 执行了 Scheduled" + ThreadLocalRandom.current().nextInt(3));
    }
}

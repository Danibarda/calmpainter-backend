package com.calmpainter.calm.painter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

//This config file is mostly taken from/inspired by the following article: 
// https://medium.com/@munafbadarpura11/spring-boot-scheduled-tutorial-building-scheduled-tasks-with-taskscheduler-039c38fdd1c8 
@Configuration
public class TaskSchedulerConfig {
    @Bean
    public TaskScheduler taskScheduler() {

        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(4);
        return scheduler;

    }
}

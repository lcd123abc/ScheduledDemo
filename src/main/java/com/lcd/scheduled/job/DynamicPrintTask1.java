package com.lcd.scheduled.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class DynamicPrintTask1 implements ScheduledOfTask {
    @Value("${task.output}")
    private String output;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private int i;
    @Override
    public void execute() {
        logger.info("thread id:{},DynamicPrintTask1 execute times:{},OutPut:{}", Thread.currentThread().getId(), ++i,output);
    }

}
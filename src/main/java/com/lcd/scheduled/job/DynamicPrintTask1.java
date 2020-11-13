package com.lcd.scheduled.job;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Slf4j
public class DynamicPrintTask1 implements ScheduledOfTask {
    @Value("${task.output}")
    private String output;
    private int i;
    @Override
    public void execute() {
        log.info("thread id:{},DynamicPrintTask1 execute times:{},OutPut:{}", Thread.currentThread().getId(), ++i,output);
    }

}
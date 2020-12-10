package com.lcd.scheduled.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DynamicPrintTask2 implements ScheduledOfTask {
    private int i;
    @Override
    public void execute() {
        log.info("thread id:{},DynamicPrintTask2 execute times:{}", Thread.currentThread().getId(), ++i);
    }

}
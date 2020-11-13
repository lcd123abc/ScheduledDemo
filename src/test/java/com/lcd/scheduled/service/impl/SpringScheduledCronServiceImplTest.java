package com.lcd.scheduled.service.impl;

import com.lcd.scheduled.entiry.SpringScheduledCron;
import com.lcd.scheduled.service.SpringScheduledCronService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringScheduledCronServiceImplTest {
    private SpringScheduledCronService springScheduledCronService;
    @Test
    void findByTaskJobClass() {
        SpringScheduledCron springScheduledCron = springScheduledCronService.findByTaskJobClass("com.lcd.scheduled.job.DynamicPrintTask");
        assertNotNull(springScheduledCron);
        System.out.println(springScheduledCron);
    }

    @Test
    void findAll() {
        List<SpringScheduledCron> all = springScheduledCronService.findAll();
        assertNotNull(all);
        System.out.println(all);
    }

    @Test
    void update(){
        SpringScheduledCron springScheduledCron = new SpringScheduledCron();
        springScheduledCron.setId(1);
        springScheduledCron.setTaskExplain("定时任务描述，测试修改");
        springScheduledCronService.update(springScheduledCron);
    }

    @Autowired
    public void setSpringScheduledCronService(SpringScheduledCronService springScheduledCronService) {
        this.springScheduledCronService = springScheduledCronService;
    }
}
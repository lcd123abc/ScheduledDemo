package com.lcd.scheduled.service;

import com.lcd.scheduled.entiry.SpringScheduledCron;

import java.util.List;

public interface SpringScheduledCronService {
    SpringScheduledCron findByTaskJobClass(String taskJobClass);

    List<SpringScheduledCron> findAll();

    void update(SpringScheduledCron springScheduledCron);
}

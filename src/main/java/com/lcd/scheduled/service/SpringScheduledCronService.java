package com.lcd.scheduled.service;

import com.lcd.scheduled.entiry.SpringScheduledCron;

import java.util.List;

public interface SpringScheduledCronService {
    /**
     * 根据类名查找 SpringScheduledCron 实体
     * @param taskJobClass 类名
     * @return SpringScheduledCron
     */
    SpringScheduledCron findByTaskJobClass(String taskJobClass);

    /**
     * 查询所有 SpringScheduledCron
     * @return List<SpringScheduledCron>
     */
    List<SpringScheduledCron> findAll();

    /**
     * 根据id更新对应字段
     * @param springScheduledCron 包含id的SpringScheduledCron实例
     */
    void update(SpringScheduledCron springScheduledCron);

    /**
     * 插入新的记录
     * @param springScheduledCron springScheduledCron实例
     */
    void save(SpringScheduledCron springScheduledCron);
}

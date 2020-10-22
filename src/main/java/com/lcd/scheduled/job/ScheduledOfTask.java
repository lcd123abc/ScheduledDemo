package com.lcd.scheduled.job;

import com.lcd.scheduled.dao.SpringScheduledCronDao;
import com.lcd.scheduled.entiry.SpringScheduledCron;
import com.lcd.scheduled.enums.StatusEnum;
import com.lcd.scheduled.utils.SpringUtils;

public interface ScheduledOfTask extends Runnable {
    void execute();

    @Override
    default void run() {
        SpringScheduledCronDao repository = SpringUtils.getBean(SpringScheduledCronDao.class);
        SpringScheduledCron scheduledCron = repository.findByTaskJobClass(this.getClass().getName());
        if (StatusEnum.DISABLED.getCode().equals(scheduledCron.getStatus())) {
            // 任务是禁用状态
            return;
        }
        execute();
    }
}

package com.lcd.scheduled.service.impl;

import com.lcd.scheduled.dao.SpringScheduledCronDao;
import com.lcd.scheduled.entiry.SpringScheduledCron;
import com.lcd.scheduled.service.SpringScheduledCronService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional(rollbackFor = Exception.class)
public class SpringScheduledCronServiceImpl implements SpringScheduledCronService {
    private SpringScheduledCronDao springScheduledCronDao;

    /**
     * 根据类名查找对应的后台任务
     * @param taskJobClass
     * @return
     */
    @Override
    public SpringScheduledCron findByTaskJobClass(String taskJobClass) {
        if (StringUtils.isNotBlank(taskJobClass)){
            return Optional.of(springScheduledCronDao.findByTaskJobClass(taskJobClass)).get();
        }
        return null;
    }

    @Override
    public List<SpringScheduledCron> findAll() {
        return Optional.of(springScheduledCronDao.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public void update(SpringScheduledCron springScheduledCron) {
        if (Objects.nonNull(springScheduledCron.getId())){
            springScheduledCronDao.update(springScheduledCron);
        }
    }

    @Autowired
    public void setSpringScheduledCronDao(SpringScheduledCronDao springScheduledCronDao) {
        this.springScheduledCronDao = springScheduledCronDao;
    }
}

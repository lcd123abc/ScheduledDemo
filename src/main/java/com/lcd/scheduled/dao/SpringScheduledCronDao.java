package com.lcd.scheduled.dao;

import com.lcd.scheduled.entiry.SpringScheduledCron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringScheduledCronDao extends JpaRepository<SpringScheduledCron, Integer> {

    SpringScheduledCron findByTaskJobClass(String taskJobClass);
}

package com.lcd.scheduled.dao;

import com.lcd.scheduled.entiry.SpringScheduledCron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SpringScheduledCronDao extends JpaRepository<SpringScheduledCron, Integer>, JpaSpecificationExecutor<SpringScheduledCron> {

    SpringScheduledCron findByTaskJobClass(String taskJobClass);

    @Modifying
    @Query("update SpringScheduledCron ssc set " +
            "ssc.cronExpression = case when :#{#condition.cronExpression} is null then ssc.cronExpression else :#{#condition.cronExpression} end," +
            "ssc.status = case when :#{#condition.status} is null then ssc.status else :#{#condition.status} end," +
            "ssc.taskExplain = case when :#{#condition.taskExplain} is null then ssc.taskExplain else :#{#condition.taskExplain} end," +
            "ssc.taskJobClass = case when :#{#condition.taskJobClass} is null then ssc.taskJobClass else :#{#condition.taskJobClass} end " +
            "where ssc.id = :#{#condition.id}")
    void update(@Param("condition") SpringScheduledCron springScheduledCron);
}

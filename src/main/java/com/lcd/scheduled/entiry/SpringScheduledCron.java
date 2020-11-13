package com.lcd.scheduled.entiry;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "spring_scheduled_cron")
@ToString
public class SpringScheduledCron {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "task_job_class")
    private String taskJobClass;
    @Column(name = "cron_expression")
    private String cronExpression;
    @Column(name = "task_explain")
    private String taskExplain;
    @Column(name = "status")
    private Integer status;
}

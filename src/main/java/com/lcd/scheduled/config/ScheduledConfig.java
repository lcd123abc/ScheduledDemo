package com.lcd.scheduled.config;


import com.lcd.scheduled.entiry.SpringScheduledCron;
import com.lcd.scheduled.job.ScheduledOfTask;
import com.lcd.scheduled.service.SpringScheduledCronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
    private ApplicationContext context;
    private SpringScheduledCronService springScheduledCronService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        for (SpringScheduledCron springScheduledCron : springScheduledCronService.findAll()) {
            Runnable task;
            try {
                task = context.getBean(springScheduledCron.getClassId(),Runnable.class);
            } catch (Exception e) {
                throw new IllegalArgumentException("spring_scheduled_cron 表数据" + springScheduledCron.getTaskJobClass() + "有误", e);
            }
            Assert.isAssignable(ScheduledOfTask.class, task.getClass(), "定时任务类必须实现ScheduledOfTask接口");
            // 可以通过改变数据库数据进而实现动态改变执行周期
            scheduledTaskRegistrar.addTriggerTask(task,
                    triggerContext -> {
                        String cronExpression = springScheduledCronService.findByTaskJobClass(springScheduledCron.getTaskJobClass()).getCronExpression();
                        return new CronTrigger(cronExpression).nextExecutionTime(triggerContext);
                    }
            );
        }
    }

    /**
     * 自定义线程池
     * @return threadPoolTaskExecutor
     */
    @Bean
    public Executor taskExecutor() {
        // spring封装的 ThreadPoolExecutor
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数
        threadPoolTaskExecutor.setCorePoolSize(10);
        // 最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(200);
        // 队列容量
        threadPoolTaskExecutor.setQueueCapacity(10);
        // 线程活跃时间
        threadPoolTaskExecutor.setKeepAliveSeconds(20);
        // 拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolTaskExecutor;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    @Autowired
    public void setSpringScheduledCronService(SpringScheduledCronService springScheduledCronService) {
        this.springScheduledCronService = springScheduledCronService;
    }
}

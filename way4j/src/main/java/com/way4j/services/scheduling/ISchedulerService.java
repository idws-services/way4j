package com.way4j.services.scheduling;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;

import com.way4j.services.IGenericService;

public interface ISchedulerService extends IGenericService {

	void schedule(Job job, String cronExpression);
	void schedule(JobDetail jobDetail, CronTrigger cronTrigger) throws SchedulerException;
	
}

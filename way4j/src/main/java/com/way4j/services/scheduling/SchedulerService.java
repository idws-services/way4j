package com.way4j.services.scheduling;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.way4j.appConfig.PropertyConfigurator;

public class SchedulerService implements ISchedulerService {
	
	private StdSchedulerFactory schedulerFactory;
	private Scheduler scheduler;
	
	public SchedulerService(){
		try {
			schedulerFactory =	new StdSchedulerFactory(PropertyConfigurator.getProperties(StdSchedulerFactory.class));
			scheduler = schedulerFactory.getScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void schedule(Job job, String cronExpression){
		try {
			JobDetail jobDetail = new JobDetail(getJobName(job), getDefaultJobGroupName(), job.getClass());
			CronTrigger cronTrigger = new CronTrigger();
			cronTrigger.setCronExpression(cronExpression);
			cronTrigger.setName(getCronName(job));
			schedule(jobDetail, cronTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void schedule(JobDetail jobDetail, CronTrigger cronTrigger) throws SchedulerException {
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}
	
	private String getJobName(Job job){
		return job.getClass().getSimpleName()+"-job";
	}
	
	private String getCronName(Job job){
		return job.getClass().getSimpleName()+"-cronTrigger";
	}
	
	public Scheduler getScheduler(){
		return scheduler;
	}
	
	public SchedulerFactory getSchedulerFactory(){
		return schedulerFactory;
	}
	
	public String getDefaultJobGroupName(){
		return "defaultJobGroup";
	}
	
}
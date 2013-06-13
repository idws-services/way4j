package com.way4j.listeners;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(new Date());
	}
}

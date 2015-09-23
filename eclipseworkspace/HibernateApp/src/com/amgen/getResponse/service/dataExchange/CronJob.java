package com.amgen.getResponse.service.dataExchange;
import java.util.ResourceBundle;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class CronJob {
	private Scheduler sched;
	
	CronJob(){
		sched=null;
	}
	
	protected Scheduler configureScheduler(){
		try {
			ResourceBundle bundle=ResourceBundle.getBundle("properties.cron");
			String cronExpression=bundle.getString("cronExpression");
//			System.out.println(cronExpression);
			if(CronExpression.isValidExpression(cronExpression)){
				JobDetail jd=JobBuilder
						.newJob(DataTransferJob.class)
						.withIdentity("EncryptionJob")
						.build();
				
				Trigger t=TriggerBuilder
						.newTrigger()
						.withIdentity("EncryptionJob")
						.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
						.build();
				
				SchedulerFactory sf=new StdSchedulerFactory();
				sched=sf.getScheduler();
				sched.scheduleJob(jd, t);
				
			}
			
			else{
				System.out.println("Invalid cron Expression");
				sched=null;
			}
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return sched;
	}
	
	protected void startScheduler(){
		try {
			sched.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void stopScheduler(){
		try {
			sched.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


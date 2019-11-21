package com.example.bootwithdocker;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;

public class HelloJob implements Job {

    private static int count = 0;
    private String name;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        name += ++count;
        System.out.println(Calendar.getInstance().getTime() + "hello " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
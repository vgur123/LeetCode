package org.easy.threads.executors;

import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args)
    {

        // Creating a ScheduledThreadPoolExecutor object
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(2);

        // Creating two Runnable objects
        Runnable task1 = new Command("task1");
        Runnable task2 = new Command("task2");

        // Printing the current time in seconds
        System.out.println(
                "Current time : " + Calendar.getInstance().get(Calendar.SECOND));

        // Scheduling the first task which will execute after 2 seconds
        threadPool.schedule(task1, 2, TimeUnit.SECONDS);

        // Scheduling the second task which will execute after 5 seconds
        threadPool.schedule(task2, 5, TimeUnit.SECONDS);

        // Remember to shut sown the Thread Pool
        threadPool.shutdown();
    }
}

class Command implements Runnable {
    String taskName;
    public Command(String taskName)
    {
        this.taskName = taskName;
    }
    public void run()
    {
        System.out.println(
                "Task name : " + this.taskName + " Current time: "
                        + Calendar.getInstance().get(Calendar.SECOND));
    }
}


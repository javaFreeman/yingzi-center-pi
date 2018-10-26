package com.yingzi.center.pi.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.Objects;
/**
 * @program: yingzi-app-pi
 * @description: 线程池用例
 * @author: BaoGuoQiang
 * @create: 2018-10-26 10:27
 **/

public class ThreadPoolTest {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中的线程数目："+executor.getPoolSize()+
                    "，队列中等待执行的任务数目："+executor.getQueue().size()+
                    "，已执行完的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num){
        this.taskNum = num;
    }

    @Override
    public void run(){
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.sleep(4000+taskNum*2);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+" 执行完毕");
    }
}
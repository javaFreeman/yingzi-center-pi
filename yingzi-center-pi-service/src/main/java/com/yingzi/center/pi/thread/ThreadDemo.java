package com.yingzi.center.pi.thread;

/**
 * @program: yingzi-app-pi
 * @description: 通过继承Thread来创建线程
 * @author: BaoGuoQiang
 * @create: 2018-10-25 11:42
 **/

public class ThreadDemo extends Thread {

    private String threadName;

    ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating:" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo("Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-2");
        T2.start();
    }
}
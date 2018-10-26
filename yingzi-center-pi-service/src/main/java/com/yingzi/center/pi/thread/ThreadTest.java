package com.yingzi.center.pi.thread;

/**
 * @program: yingzi-app-pi
 * @description: 传统的与lambda创建线程
 * @author: BaoGuoQiang
 * @create: 2018-10-24 19:38
 **/


//继承 Thread 类
public class ThreadTest extends Thread{
    private int count = 10;
    //覆写run方法
    @Override
    public void run(){
        while (true){
            System.out.println("Hi! It's " +count);
            if (--count == 0){
                break;
            }
        }
    }
    public static void main(String[] args){
        //创建一个线程类的对象
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();

        /**
         * use Lambda create thread
         */
        new Thread(
                () ->{
                    System.out.println("Hello world!");
                    System.out.println("Jimmy!");
                }
        ).start(); //通过start方法启动线程
    }
}
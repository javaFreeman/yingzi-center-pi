package com.yingzi.center.pi.thread.threadMethodTest;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-25 14:33
 **/

public class DisplayMessage implements Runnable{
    private String message;
    private int count = 0;

    public DisplayMessage(String message){
        this.message = message;
    }

    @Override
    public void run(){
        while (true){
            System.out.println(message);
        }
    }
}
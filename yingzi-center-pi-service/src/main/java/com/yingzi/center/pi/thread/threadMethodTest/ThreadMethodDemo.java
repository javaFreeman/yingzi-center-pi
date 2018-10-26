package com.yingzi.center.pi.thread.threadMethodTest;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-25 14:45
 **/

public class ThreadMethodDemo {

    public static void main(String[] args){
        /*Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Start hello thread...");
        thread1.start();

        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Starting goodbye thread...");
        thread2.start();
*/
        System.out.println("Starting thread3...");
        Thread thread3 = new GuessNumber(27);
        thread3.start();
        try {
            thread3.join();
        }catch(InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Starting thread4...");
        Thread thread4 = new GuessNumber(75);

        thread4.start();
        System.out.println("main() is ending...");
    }
}
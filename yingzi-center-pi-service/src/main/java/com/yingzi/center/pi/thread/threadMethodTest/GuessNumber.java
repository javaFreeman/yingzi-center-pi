package com.yingzi.center.pi.thread.threadMethodTest;

/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-25 14:39
 **/

public class GuessNumber extends Thread{
    private int number;

    public GuessNumber(int number){
        this.number = number;
    }

    @Override
    public void run(){
        int counter = 0;
        int guess = 0;
        do {
            guess = (int) (Math.random()*100 + 1);
            System.out.println(this.getName()+" guesses "+guess);
            counter++;
        }while (guess != number);
        System.out.println("** Correct!" + this.getName() + " in " + counter + "guesses.**");
    }
}
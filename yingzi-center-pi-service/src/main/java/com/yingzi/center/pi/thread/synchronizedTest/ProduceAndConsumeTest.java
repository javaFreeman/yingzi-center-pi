package com.yingzi.center.pi.thread.synchronizedTest;


/**
 * @program: yingzi-app-pi
 * @description:
 * @author: BaoGuoQiang
 * @create: 2018-10-25 10:02
 **/

public class ProduceAndConsumeTest {
    private int Product;
    private int Max_Product;
    private int MIN_Product;

    ProduceAndConsumeTest(int Max_Product,int MIN_Product){
        this.Max_Product = Max_Product;
        this.MIN_Product = MIN_Product;
    }
    /**
     *  生产者生产出来的产品交给店员
     */
    public synchronized void produce(){
        if (this.Product >= Max_Product){
            try {
                wait();
                System.out.println("产品已满，请稍后再生产");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return;
        }

        this.Product++;
        System.out.println("生产者生产第" + this.Product + "个产品.");
        //通知等待区的消费者可以取出产品了
        notifyAll();
    }

    /**
     *  消费者购买产品
     */
    public synchronized void consume(){
        if (this.Product <= MIN_Product){
            try {
                wait();
                System.out.println("缺货，请稍后购买");
            } catch (InterruptedException e){
            e.printStackTrace();
            }
            return;
        }

        this.Product--;
        System.out.println("消费者取走了第" + this.Product + "个产品.");
        //通知等待中的生产者可以生产了
        notifyAll();
    }

    public static void main(String[] args){
        ProduceAndConsumeTest test = new ProduceAndConsumeTest(20,5);
        test.Product = 0;
        for (int count = 0;count<100;count++ ) {
            test.produce();
            test.consume();
        }
    }

}
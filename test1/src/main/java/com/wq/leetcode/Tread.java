package com.wq.leetcode;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * Tread
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/1 10:41
 * @see Tread
 * To change this template use File | Settings | File Templates.
 */

public class Tread extends Thread implements Serializable{
    private static final long serialVersionUID = -2053237809715648328L;
    protected CountDownLatch countDownLatch;
    protected CountDownLatch countDownLatch2;
    public Tread(String a,CountDownLatch c,CountDownLatch c2) {
        this.setName(a);
        countDownLatch = c;
        countDownLatch2 = c2;
    }

    @Override
    public void run() {
        System.out.println("===="+this.getName()+"准备");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if( Tread.currentThread().getName().equals("C")){
            System.out.println(this.getName());
        }else{
            System.out.print(this.getName());
        }

        if(countDownLatch2!=null){
            countDownLatch2.countDown();
        }


    }
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            CountDownLatch countDownLatch = new CountDownLatch(0);
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            CountDownLatch countDownLatch3 = new CountDownLatch(1);
            CountDownLatch countDownLatch4 = new CountDownLatch(1);
            Tread t = new Tread("A",countDownLatch,countDownLatch2);
            t.start();
            Tread t2 = new Tread("B",countDownLatch2,countDownLatch3);
            t2.start();
            Tread t3 = new Tread("C",countDownLatch3,countDownLatch4);
            t3.start();
            try {
                countDownLatch4.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

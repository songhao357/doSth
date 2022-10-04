package com.songhao.demo.exercise.current;

import java.util.concurrent.TimeUnit;

public class T01_Thread {

    public static void main(String[] args) {
        new T1().start();
        new T1().run();

    }
}

class T1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("T1");
        }
    }
}


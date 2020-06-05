package com.designpatterns.proxy.fly;

import java.util.Random;

/**
 * 最原始的bird类，实现flyable接口，拥有flyable方法
 */
public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("bird if flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.designpatterns.proxy.fly;


/**
 * 通过继承的方法增强代码
 */
public class Bird1 extends Bird {
    @Override
    public void fly() {
        float start = System.currentTimeMillis();
        super.fly();
        float end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

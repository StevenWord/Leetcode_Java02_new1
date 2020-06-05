package com.designpatterns.proxy.fly;

public class Bird2 implements Flyable {
    private Bird bird ;

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Bird getBird() {
        return bird;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        bird.fly();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

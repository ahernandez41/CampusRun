package com.csus.csc133two;

public class Lecture {
    private int remainingTime;

    public Lecture(int time) {
        this.remainingTime = time;
    }

    public void tick() {
        if (remainingTime > 0) {
            remainingTime--;
        }
    }

    public void end() {
        remainingTime = 0;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    @Override
    public String toString() {
        return "Lecture time remaining: " + remainingTime;
    }
}

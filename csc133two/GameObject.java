package com.csus.csc133two;

import com.codename1.ui.Graphics;

public abstract class GameObject {
    private int x;
    private int y;
    private int size;
    private int color;
    private String characteristic;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 50;
        this.color = 0x000000;
    }

    public String getCharacteristic() {
        return characteristic != null ? characteristic : "Default";  // Ensure non-null
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean contains(int px, int py) {
        int halfSize = size / 2;
        return px >= x - halfSize && px <= x + halfSize && py >= y - halfSize && py <= y + halfSize;
    }

    public abstract void draw(Graphics g, int offsetX, int offsetY);
}

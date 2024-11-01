package com.csus.csc133two;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public abstract class Student extends GameObject {
    protected String characteristic;

    public Student(int x, int y, String characteristic) {
        super(x, y);
        this.characteristic = characteristic;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
    
    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
    	g.setColor(getColor());
        int size = getSize();
        g.fillArc(getX() + offsetX, getY() + offsetY, size, size, 0, 360); // Draw circle
        g.setColor(ColorUtil.BLACK);
        g.drawString(getCharacteristic(), getX() + offsetX, getY() + offsetY + size + 40);
    }
}
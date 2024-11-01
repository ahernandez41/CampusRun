package com.csus.csc133two;

import com.codename1.ui.Graphics;

public class Triangle extends GameObject {
    public Triangle(int x, int y) {
        super(x, y);
        setSize(40);
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(getColor());
        int[] xPoints = {getX() + offsetX, getX() + offsetX + getSize() / 2, getX() + offsetX - getSize() / 2};
        int[] yPoints = {getY() + offsetY, getY() + offsetY + getSize(), getY() + offsetY + getSize()};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}

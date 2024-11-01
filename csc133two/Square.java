package com.csus.csc133two;

import com.codename1.ui.Graphics;

public class Square extends GameObject {
    public Square(int x, int y) {
        super(x, y);
        setSize(40);
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(getColor());
        int size = getSize();
        g.fillRect(getX() + offsetX, getY() + offsetY, size, size);
    }
}

package com.csus.csc133two;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class WaterDispenser extends GameObject {
    public WaterDispenser(int x, int y) {
        super(x, y);
        setSize(40);
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(getColor());
        int size = getSize();
        g.fillArc(getX() + offsetX, getY() + offsetY, size, size, 0, 360); // Draw circle
        g.setColor(ColorUtil.BLACK);

        // Ensure that the characteristic string is not null
        String characteristic = getCharacteristic();
        if (characteristic == null) {
            characteristic = "Default Characteristic"; // Default value if null
        }
        g.drawString(characteristic, getX() + offsetX, getY() + offsetY + size + 40);
    }
}


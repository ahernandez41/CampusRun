package com.csus.csc133two;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class StudentPlayer extends Student {
    private static StudentPlayer instance;
    private int direction;
    
    
    private StudentPlayer(int x, int y) {
    	
        super(x, y, " ");//leave empty
        setColor(ColorUtil.rgb(0, 200, 0)); // Green color for player
        direction = 0;
    }

    public static StudentPlayer getInstance(int x, int y) {
        if (instance == null) {
            instance = new StudentPlayer(x, y);
        }
        return instance;
    }

    public void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }

    public void stop() {
    }

    public void turnLeft() {
        direction -= 90;
        if (direction < 0) {
        	direction += 360; 
        }
    }

    public void turnRight() {
        direction += 90;
        if (direction >= 360) {
        	direction -= 360; 
        }
    }

    public void changeStrategy() {
        // Implement the logic to change strategy
       // if ("default".equals(currentStrategy)) {
          //  currentStrategy = "aggressive";
       // } else if ("aggressive".equals(currentStrategy)) {
         //   currentStrategy = "defensive";
       // } else {
        //    currentStrategy = "default";
        }
   
    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(getColor());
        int size = getSize();
        int halfSize = size / 2;
        int[] xPoints = {getX() + offsetX, getX() + offsetX + halfSize, getX() + offsetX - halfSize};
        int[] yPoints = {getY() + offsetY - halfSize, getY() + offsetY + halfSize, getY() + offsetY + halfSize};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}

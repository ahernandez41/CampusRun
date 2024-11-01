package com.csus.csc133two;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class StudentAngry extends Student {
    private static final int BOUNDARY_WIDTH = 1280;
    private static final int BOUNDARY_HEIGHT = 1280;
    private Deque<int[]> lastMoves;
    private Random random;
    private int stepCounter;

    public StudentAngry(int x, int y) {
        super(x, y, "Argh!!");
        setColor(ColorUtil.rgb(255, 0, 0)); // Red color for angry student
        random = new Random();
        stepCounter = 0;
        lastMoves = new ArrayDeque<>();
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

    public void wander() {
        if (stepCounter % 10 == 0) {
            int dx, dy;
            do {
                dx = random.nextInt(100) - 50; // Move between -10 and +10 units in x
                dy = random.nextInt(100) - 50; // Move between -10 and +10 units in y
            } while (isReverseMove(dx, dy));

            // Boundary checks
            int newX = getX() + dx;
            int newY = getY() + dy;
            if (newX < 0) newX = 0;
            if (newY < 0) newY = 0;
            if (newX > BOUNDARY_WIDTH) newX = BOUNDARY_WIDTH;
            if (newY > BOUNDARY_HEIGHT) newY = BOUNDARY_HEIGHT;

            setLocation(newX, newY);

            // Record the move
            lastMoves.addFirst(new int[]{dx, dy});
            if (lastMoves.size() > 5) { // Keep track of the last 5 moves
                lastMoves.removeLast();
            }
        }
        stepCounter++;
    }

    private boolean isReverseMove(int dx, int dy) {
        // Check if the move is the reverse of any of the last few moves
        for (int[] move : lastMoves) {
            if (dx == -move[0] && dy == -move[1]) {
                return true;
            }
        }
        return false;
    }
}

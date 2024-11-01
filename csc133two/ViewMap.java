package com.csus.csc133two;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;

import java.util.Observable;
import java.util.Observer;
import java.util.Iterator;

public class ViewMap extends Container implements Observer {
    private GameModel model;

    public ViewMap(GameModel model) {
        this.model = model;
        this.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.rgb(255, 0, 0)));
        this.getAllStyles().setBgColor(ColorUtil.LTGRAY);
        this.getAllStyles().setBgTransparency(255);
        this.addPointerPressedListener(evt -> handlePointerPress(evt.getX(), evt.getY()));
    }
    
    private void handlePointerPress(int x, int y) {
    	  x -= getAbsoluteX();
          y -= getAbsoluteY();
          GameObject selected = null;
          for (Iterator<GameObject> it = model.getIterator(); it.hasNext();) {
              GameObject obj = it.next();
              if (obj.contains(x, y)) {
                  selected = obj;
                  break;
              }
          }
          model.setSelectedObject(selected);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof GameModel) {
            this.repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<GameObject> iterator = model.getIterator();
        while (iterator.hasNext()) {
            GameObject obj = iterator.next();
            obj.draw(g, this.getX(), this.getY());
            g.setColor(ColorUtil.BLACK);
            String simpleName = obj.getClass().getSimpleName();
            int lastDot = simpleName.lastIndexOf('.');
            if (lastDot > 0) {
            	simpleName = simpleName.substring(lastDot + 1);
            }
            g.drawString(simpleName, obj.getX() + getX(), obj.getY() + getY() + obj.getSize() + 5);
        }
    }
}

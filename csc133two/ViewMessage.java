package com.csus.csc133two;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

import java.util.Observable;
import java.util.Observer;

public class ViewMessage extends Container implements Observer {
    private Label message;

    public ViewMessage() {
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        this.message = new Label("Game Start!");
        this.add(message);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof GameModel) {
            GameModel model = (GameModel) o;
            message.setText(model.getLatestMessage());
            this.revalidate();
        }
    }
    
}

package com.csus.csc133two;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

import java.util.Observable;
import java.util.Observer;

public class ViewStatus extends Container implements Observer {
    private GameModel model;
    private Label lectureHall;
    private Label lectureTimeRemaining;
    private Label gameTime;
    private Label absence;
    private Label hydration;
    private Label waterIntake;
    private Label hold;

    public ViewStatus(GameModel model) {
        this.model = model;
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        this.lectureHall = new Label("Lecture Hall: None");
        this.lectureTimeRemaining = new Label("Lecture Time Remaining: 0");
        this.gameTime = new Label("Game Time: 0");
        this.absence = new Label("Absence: 0");
        this.hydration = new Label("Hydration: 0");
        this.waterIntake = new Label("Water Intake: 0");
        this.hold = new Label("Hold: 0");

        this.add(lectureHall);
        this.add(lectureTimeRemaining);
        this.add(gameTime);
        this.add(absence);
        this.add(hydration);
        this.add(waterIntake);
        this.add(hold);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof GameModel) {
            lectureHall.setText("Lecture Hall: " + model.getLectureHall());
            lectureTimeRemaining.setText("Lecture Time Remaining: " + model.getTimeRemain());
            gameTime.setText("Game Time: " + model.getGameTime());
            absence.setText("Absence: " + model.getAbsences());
            hydration.setText("Hydration: " + model.getHydration());
            waterIntake.setText("Water Intake: " + model.getWaterIntake());
            hold.setText("Hold: " + model.getHold());
            this.revalidate();
        }
    }
}


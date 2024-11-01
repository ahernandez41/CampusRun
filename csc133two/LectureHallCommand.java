package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LectureHallCommand extends Command {
    private GameModel model;

    public LectureHallCommand(GameModel model) {
        super("Lecture Hall");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.goToLectureHall();
    }
}

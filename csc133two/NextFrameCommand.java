package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class NextFrameCommand extends Command {
    private GameModel model;

    public NextFrameCommand(GameModel model) {
        super("Next Frame");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.nextFrame();
    }
}

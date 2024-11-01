package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class StopCommand extends Command {
    private GameModel model;

    public StopCommand(GameModel model) {
        super("Stop");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.stopPlayer();
    }
}

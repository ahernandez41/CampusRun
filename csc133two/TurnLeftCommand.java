package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnLeftCommand extends Command {
    private GameModel model;

    public TurnLeftCommand(GameModel model) {
        super("Turn Left");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.movePlayer(-100,0);
    }
}

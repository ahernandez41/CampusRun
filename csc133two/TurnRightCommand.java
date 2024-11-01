package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TurnRightCommand extends Command {
    private GameModel model;

    public TurnRightCommand(GameModel model) {
        super("Turn Right");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.movePlayer(100,0);
    }
}

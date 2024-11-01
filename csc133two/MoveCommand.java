package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveCommand extends Command {
    private GameModel model;

    public MoveCommand(GameModel model) {
        super("Move");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.movePlayer(100, 0); // Example move, adjust as needed
    }
}

package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveUpCommand extends Command {
    private GameModel model;

    public MoveUpCommand(GameModel model) {
        super("Move Up");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.movePlayer(0, -100);
    }
}

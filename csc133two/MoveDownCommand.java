package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class MoveDownCommand extends Command {
    private GameModel model;

    public MoveDownCommand(GameModel model) {
        super("Move Down");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.movePlayer(0, 100);
    }
}

package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RestroomCommand extends Command {
    private GameModel model;

    public RestroomCommand(GameModel model) {
        super("Restroom");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.goToRestroom();
    }
}

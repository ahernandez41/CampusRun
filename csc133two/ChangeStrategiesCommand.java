package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ChangeStrategiesCommand extends Command {
    private GameModel model;

    public ChangeStrategiesCommand(GameModel model) {
        super("Change Strategies");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.changeStrategies();
    }
}


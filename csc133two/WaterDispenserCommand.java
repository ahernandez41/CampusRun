package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class WaterDispenserCommand extends Command {
    private GameModel model;

    public WaterDispenserCommand(GameModel model) {
        super("Water Dispenser");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        model.goToWaterDispenser();
    }
}

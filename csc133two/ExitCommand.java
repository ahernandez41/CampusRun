package com.csus.csc133two;

import com.codename1.ui.CN;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        boolean exit = Dialog.show("Exit", "Are you sure you want to exit?", "Yes", "No");
        if (exit) {
            CN.exitApplication();
        }
    }
}

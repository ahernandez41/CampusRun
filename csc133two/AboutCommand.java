package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {

    public AboutCommand() {
        super("About");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Dialog.show("About", "A2, Arianna Hernandez, Summer 2024", "Confirm", null);
    }
}

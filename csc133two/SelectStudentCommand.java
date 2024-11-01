package com.csus.csc133two;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.Button;

public class SelectStudentCommand extends Command {
    private GameModel model;

    public SelectStudentCommand(GameModel model) {
        super("Student");
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Dialog dialog = new Dialog("Select Student");
        dialog.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        TextField inputField = new TextField("", "Enter student number (0-9)", 4, TextField.NUMERIC);
        dialog.add(inputField);

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");

        okButton.addActionListener(e -> {
            String input = inputField.getText();
            if (input != null && !input.isEmpty()) {
                try {
                    int studentNumber = Integer.parseInt(input);
                    model.selectStudent(studentNumber);
                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    Dialog.show("Error", "Invalid number entered", "OK", null);
                }
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.add(okButton);
        dialog.add(cancelButton);
        dialog.show();
    }
}

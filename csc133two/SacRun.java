package com.csus.csc133two;

import java.util.Iterator;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;

public class SacRun extends Form implements Runnable {
    private GameModel gm;
    private ViewStatus vs;
    private ViewMessage vm;
    private ViewMap vmap;
    private UITimer timer;
    private boolean isPaused = false;

    public SacRun(Resources theme) {
        super(new BorderLayout());
        gm = new GameModel();

        vs = new ViewStatus(gm);
        vm = new ViewMessage();
        vmap = new ViewMap(gm);

        // Adjust layout constraints
        this.add(BorderLayout.EAST, vs);
        this.add(BorderLayout.SOUTH, vm);
        this.add(BorderLayout.CENTER, vmap);

        Container westContainer = createCommandPanel();
        westContainer.getAllStyles().setMargin(Component.RIGHT, 10); // Adjust margin if needed
        this.add(BorderLayout.WEST, westContainer);

        getToolbar().addCommandToSideMenu(new ChangeStrategiesCommand(gm));
        getToolbar().addCommandToSideMenu(new AboutCommand());
        getToolbar().addCommandToSideMenu(new ExitCommand());
       // getToolbar().addCommandToSideMenu(new MoveCommand(gm));
      //  getToolbar().addCommandToSideMenu(new MoveUpCommand(gm));
       // getToolbar().addCommandToSideMenu(new MoveDownCommand(gm));
      //  getToolbar().addCommandToSideMenu(new TurnLeftCommand(gm));
        //getToolbar().addCommandToSideMenu(new TurnRightCommand(gm));
        
        gm.addObserver(vs);
        gm.addObserver(vm);
        gm.addObserver(vmap);

        // Start the timer for animation
        timer = new UITimer(this);
        timer.schedule(20, true, this);
        addKeyListeners();
    }
    
    private void addKeyListeners() {
        this.addPointerPressedListener(evt -> handlePointerPress(evt.getX(), evt.getY()));
        addKeyListener('w', e -> gm.movePlayer(0, -100));
        addKeyListener('a', e -> gm.movePlayer(-100, 0));
        addKeyListener('s', e -> gm.movePlayer(0, 100));
        addKeyListener('d', e -> gm.movePlayer(100, 0));
    }
    private void handlePointerPress(int x, int y) {
        x -= getAbsoluteX();
        y -= getAbsoluteY();
        GameObject selected = null;
        for (Iterator<GameObject> it = gm.getIterator(); it.hasNext();) {
            GameObject obj = it.next();
            if (obj.contains(x, y)) {
                selected = obj;
                break;
            }}
        }
    

    private Container createCommandPanel() {
        Container west = new Container(new BoxLayout(BoxLayout.Y_AXIS));

       // Button moveButton = new Button(new MoveCommand(gm));
        Button moveUpButton = new Button(new MoveUpCommand(gm));
        Button moveDownButton = new Button(new MoveDownCommand(gm));
       // Button stopButton = new Button(new StopCommand(gm));
        Button turnLeftButton = new Button(new TurnLeftCommand(gm));
        Button turnRightButton = new Button(new TurnRightCommand(gm));
        Button changeStrategiesButton = new Button(new ChangeStrategiesCommand(gm));
        Button pauseButton = new Button("Pause");
        pauseButton.addActionListener(e -> togglePause(pauseButton));
        Button changePositionButton = new Button("Change Position");
        changePositionButton.addActionListener(e -> changePosition());
        //Button lectureHallButton = new Button(new LectureHallCommand(gm));
       // Button restroomButton = new Button(new RestroomCommand(gm));
       // Button waterDispenserButton = new Button(new WaterDispenserCommand(gm));
      //  Button selectStudentButton = new Button(new SelectStudentCommand(gm));
      //  Button nextFrameButton = new Button(new NextFrameCommand(gm));

       // setButtonStyle(moveButton);
        setButtonStyle(moveUpButton);
        setButtonStyle(moveDownButton);
        setButtonStyle(pauseButton);
        setButtonStyle(changePositionButton);
       // setButtonStyle(stopButton);
        setButtonStyle(turnLeftButton);
        setButtonStyle(turnRightButton);
        setButtonStyle(changeStrategiesButton);
       // setButtonStyle(lectureHallButton);
       // setButtonStyle(restroomButton);
        //setButtonStyle(waterDispenserButton);
       // setButtonStyle(selectStudentButton);
        //setButtonStyle(nextFrameButton);

       // west.add(moveButton);
        west.add(moveUpButton);
        west.add(moveDownButton);
        west.add(pauseButton);
        west.add(changePositionButton);
       // west.add(stopButton);
        west.add(turnLeftButton);
        west.add(turnRightButton);
        west.add(changeStrategiesButton);
        //west.add(lectureHallButton);
       // west.add(restroomButton);
       // west.add(waterDispenserButton);
       // west.add(selectStudentButton);
       // west.add(nextFrameButton);

        return west;
    }

    private void setButtonStyle(Button button) {
        button.getAllStyles().setBgColor(0x0000FF); // Blue color
        button.getAllStyles().setFgColor(0xFFFFFF); // White color
        button.getAllStyles().setBgTransparency(255);
        button.getAllStyles().setPadding(2, 2, 2, 2); // Adjust padding if needed
        button.getAllStyles().setMargin(2, 2, 2, 2); // Adjust margin if needed
    }
    

    private void togglePause(Button pauseButton) {
        if (isPaused) {
            timer.schedule(20, true, this);
            pauseButton.setText("Pause");
        } else {
            timer.cancel();
            pauseButton.setText("Play");
        }
        isPaused = !isPaused;
    }
    
    private void changePosition() {
        if (isPaused && gm.getSelectedObject() != null) {
            addPointerPressedListener(e -> {
                int x = e.getX() - getParent().getAbsoluteX();
                int y = e.getY() - getParent().getAbsoluteY();
                gm.getSelectedObject().setLocation(x, y);
                repaint();
            });
        }
    }

    @Override
    public void run() {
    	if (!isPaused) {
        gm.nextFrame();
    }
}
    }


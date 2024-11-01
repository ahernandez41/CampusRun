package com.csus.csc133two;

import java.util.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameModel extends Observable {
    private ArrayList<GameObject> gameObjects;
    private int gameTime;
    private StudentPlayer player;
    private Random random; 
    private String latestMessage;
    private int lectureHall;
    private int absences;
    private int hydration;
    private int waterIntake;
    private int hold;
    private int timeRemain;
    private GameObject selectedObject;

    // Define the boundaries of the box
    private static final int BOUNDARY_WIDTH = 1280;
    private static final int BOUNDARY_HEIGHT = 1280;

    public GameModel() {
        gameObjects = new ArrayList<>();
        gameTime = 0;
        lectureHall = 0;
        absences = 0;
        hydration = 100;
        waterIntake = 0;
        hold = 0;
        timeRemain = 0;
        player = StudentPlayer.getInstance(100, 100);
        random = new Random();
        // Initialize other game objects here
        gameObjects.add(new WaterDispenser(200, 800));
        gameObjects.add(new Restroom(300, 1200));
        gameObjects.add(new WaterDispenser(800, 200));
        gameObjects.add(new Restroom(600, 500));
        gameObjects.add(new LectureHall(900, 900));
        gameObjects.add(new Facility(600, 900));
        gameObjects.add(new StudentAngry(300, 300));
        gameObjects.add(player);
    }

    public void updateGame() {
        // Update game logic here
        for (GameObject obj : gameObjects) {
            if (obj instanceof StudentAngry) {
                ((StudentAngry) obj).wander(); 
            }
        }
        latestMessage = "Game Start!"; // Update the latest message
        setChanged();
        notifyObservers();
    }

    public Iterator<GameObject> getIterator() {
        return gameObjects.iterator();
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
        setChanged();
        notifyObservers();
    }

    public void nextFrame() {
        updateGame();
    }

    public void movePlayer(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;
        
        // boundary checks
        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;
        if (newX > BOUNDARY_WIDTH) newX = BOUNDARY_WIDTH;
        if (newY > BOUNDARY_HEIGHT) newY = BOUNDARY_HEIGHT;

        player.setLocation(newX, newY);
        latestMessage = "Player moved.";
        
        setChanged();
        notifyObservers();
    }

    public void stopPlayer() {
        player.stop();
        setChanged();
        notifyObservers();
    }

    public void turnPlayerLeft() {
        player.turnLeft();
        setChanged();
        notifyObservers();
    }

    public void turnPlayerRight() {
        player.turnRight();
        setChanged();
        notifyObservers();
    }
    
    public StudentPlayer getPlayer() {
        return player;
    }

    public void changeStrategies() {
        player.changeStrategy();
        setChanged();
        notifyObservers();
    }

    public void goToLectureHall() {
        player.setLocation(70, 70);
        setChanged();
        notifyObservers();
    }

    public void goToRestroom() {
        player.setLocation(60, 60);
        setChanged();
        notifyObservers();
    }

    public void goToWaterDispenser() {
        player.setLocation(50, 50);
        setChanged();
        notifyObservers();
    }

    public void selectStudent(int studentNumber) {
        if (studentNumber >= 0 && studentNumber < gameObjects.size()) {
            GameObject selectedStudent = gameObjects.get(studentNumber);
            player.setLocation(selectedStudent.getX(), selectedStudent.getY());
            latestMessage = "Student " + studentNumber + " selected."; // Update the latest message
        } else {
            latestMessage = "Invalid student number."; // Update the latest message
        }
        setChanged();
        notifyObservers();
    }

    public void checkGameOver() {
        boolean isGameOver = false;
        // Add logic to check game over condition
        if (isGameOver) {
            latestMessage = "Game over!"; // Update the latest message
            setChanged();
            notifyObservers();
        }
    }

    public String getLatestMessage() {
        return latestMessage;
    }

    public int getLectureHall() {
        return lectureHall;
    }

    public int getAbsences() {
        return absences;
    }

    public int getHydration() {
        return hydration;
    }

    public int getWaterIntake() {
        return waterIntake;
    }

    public int getHold() {
        return hold;
    }

    public int getTimeRemain() {
        return timeRemain;
    }

    public void setSelectedObject(GameObject obj) {
        this.selectedObject = obj;
        setChanged();
        notifyObservers();
    }

    public GameObject getSelectedObject() {
        return selectedObject; // This should be selectedObject
    }
}

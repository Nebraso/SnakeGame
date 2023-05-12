package Models;


import Controllers.Controller;
import java.awt.*;
import java.util.*;

public class Snake {

    private int snakeId;
    private String snakeName;
    private int snakeTotalLength;
    private int snakeValueToTurn;
    private java.awt.Color snakeColor;
    private boolean isSnakeDeleted;
    private int snakeDirection;
    private int snakeCurrentLength = 1;
    private final int[] snakeXDirection = {0, 0, 10, 0, -10};
    private final int[] snakeYDirection = {0, 10, 0, -10, 0};
    public ArrayList<Integer> snakeXsCoordinates;
    public ArrayList<Integer> snakeYsCoordinates;

    public Snake(int id, String name, int totalLange, int Lange_des_Kopfes, Color color, int width, int height) {
        this.snakeId = id;
        this.snakeName = name;
        this.snakeColor = color;
        this.snakeTotalLength = totalLange;
        this.snakeValueToTurn = Lange_des_Kopfes;
        this.isSnakeDeleted = false;
        this.snakeDirection = (int) (Math.random() * (3)) + 1;
        snakeXsCoordinates = new ArrayList<>();
        snakeXsCoordinates.add(Controller.generateNumber(width,1));
        snakeDirection = Controller.generateNumber(5, 1);
        snakeYsCoordinates = new ArrayList<>();
        snakeYsCoordinates.add(Controller.generateNumber(height, 1));
        

    }

    public void addToXCoordinates(int x) {
        snakeXsCoordinates.add(x);
    }

    public void addToYCoordinates(int x) {
        snakeYsCoordinates.add(x);
    }

    public ArrayList<Integer> getSnakeXsCoordinates() {
        return snakeXsCoordinates;
    }

    public ArrayList<Integer> getSnakeYsCoordinates() {
        return snakeYsCoordinates;
    }

    public int getXDirection(int direction) {
        return snakeXDirection[direction];
    }

    public int getYDirection(int direction) {
        return snakeYDirection[direction];
    }

    public int getSnakeDirection() {
        return snakeDirection;
    }

    public void setNewDirection(int dir) {
        int a = Controller.generateNumber(3, 1);

        if (dir % 2 == 0) {
            if (a == 1) {
                dir = 1;
            } else {
                dir = 3;
            }
        } else if (a == 1) {
            dir = 2;
        } else {
            dir = 4;
        }
        this.snakeDirection = dir;
    }

    public void setIsSnakeDeleted(boolean isSnakeDeleted) {
        this.isSnakeDeleted = isSnakeDeleted;
    }

    public void addOneToCurrentLength() {
        this.snakeCurrentLength++;
    }

    public void setSnakeCurrentLength(int snakeCurrentLength) {
        this.snakeCurrentLength = snakeCurrentLength;
    }

    public int getSnakeCurrentLength() {
        return snakeCurrentLength;
    }

    public boolean isDel() {
        return isSnakeDeleted;
    }

    public void setSnakeId(int snakeId) {
        this.snakeId = snakeId;
    }

    public void setSnakeColor(Color snakeColor) {
        this.snakeColor = snakeColor;
    }

    public Color getSnakeColor() {
        return snakeColor;
    }

    public int getSnakeValueToTurn() {
        return snakeValueToTurn;
    }

    public void setSnakeValueToTurn(int snakeValueToTurn) {
        this.snakeValueToTurn = snakeValueToTurn;
    }

    public void setSnakeName(String snakeName) {
        this.snakeName = snakeName;
    }

    public String getSnakeName() {
        return snakeName;
    }

    public void addNewSnakeId(int snakeId) {
        this.snakeId = snakeId;
    }

    public int getSnakeId() {
        return snakeId;
    }

    public void setSnakeTotalLength(int snakeTotalLength) {
        this.snakeTotalLength = snakeTotalLength;
    }

    public int getSnakeTotalLength() {
        return snakeTotalLength;
    }

}

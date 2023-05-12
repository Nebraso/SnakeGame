package Views;


import Controllers.Controller;
import java.awt.*;
import javax.swing.*;

public class SnakePanel extends JPanel {

    Timer tmr;
    private boolean isRunning = true;
    private int[] dim;

    public SnakePanel() {
        dim = new int[2];
        tmr = new Timer(Controller.numToMs(75, 100, 0, 2000, 1), ev -> repaint());
        tmr.start();
    }

    public int getDim(int idx) {
        return dim[idx];
    }

    public void setNewTimerSpeed(int speed) {
        tmr.stop();
        tmr.setDelay(speed);
        tmr.start();
    }

    public void setDim(Dimension d) {
        dim[0] = (int) d.getWidth();
        dim[1] = (int) d.getHeight();
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        //DrawingSnakesController drawingSnakesController = new DrawingSnakesController(isRunning, dim, graphics);
        super.paintComponent(graphics);
        drawLines(graphics);
        
    }

     public void drawLines(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        if (isRunning) {
            Controller.snakes.stream().filter((s) -> (!s.isDel())).map((s) -> {
                g2d.setColor(s.getSnakeColor());
                return s;
            }).map((s) -> {
                for (int i = 0; i < s.getSnakeXsCoordinates().size(); i++) {
                    g2d.fillOval(s.getSnakeXsCoordinates().get(i), s.getSnakeYsCoordinates().get(i), 10, 10);
                }
                return s;
            }).map((s) -> {
                int tmpx, tmpy, size;
                size = s.getSnakeXsCoordinates().size() - 1;
                tmpx = s.getSnakeXsCoordinates().get(size);
                tmpy = s.getSnakeYsCoordinates().get(size);
                if (s.getSnakeCurrentLength() % s.getSnakeValueToTurn() == 0) {
                    s.setNewDirection(s.getSnakeDirection());
                }
                tmpx += s.getXDirection(s.getSnakeDirection());
                tmpy += s.getYDirection(s.getSnakeDirection());

                int loc = Controller.isOutOfBoundsAndKnowWhere(tmpx, tmpy, dim[0], dim[1]);
                if (loc == 1 || loc == 2) {
                    tmpx = Controller.adjustOutOfBoundsCorr(loc, dim[0], dim[1]);
                }
                if (loc == 3 || loc == 4) {
                    tmpy = Controller.adjustOutOfBoundsCorr(loc, dim[0], dim[1]);
                }
                if (s.getSnakeCurrentLength() > s.getSnakeTotalLength() - 1) {
                    s.getSnakeXsCoordinates().remove(0);
                    s.getSnakeYsCoordinates().remove(0);
                }
                s.addToXCoordinates(tmpx);
                s.addToYCoordinates(tmpy);
                return s;
            }).forEach((s) -> {
                s.addOneToCurrentLength();
            });

        } else {
            
 
            Controller.snakes.stream().filter((s) -> (!s.isDel())).map((s) -> {
                g2d.setColor(s.getSnakeColor());
                return s;
            }).forEach((s) -> {

                for (int i = 0; i < s.getSnakeXsCoordinates().size(); i++) {
                    g2d.fillOval(s.getSnakeXsCoordinates().get(i), s.getSnakeYsCoordinates().get(i), 10, 10);

                }
            });
              
        }

    }
}

package Views;



import Models.Snake;
import Controllers.Controller;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;


public class RemoveSnake {

    public RemoveSnake(JFrame viewFrame,JMenuItem deleteSnake) {
    deleteSnake.addActionListener((ActionEvent event) -> {

            JDialog removingDialg = new JDialog(viewFrame);
            removingDialg.setLayout(new GridLayout(Controller.getSnakeNumber(Controller.snakes), 1));
            ButtonGroup buttongroup = new ButtonGroup();
            removingDialg.setSize(50, 110 + Controller.getSnakeNumber(Controller.snakes) * 25);
            Controller.snakes.stream().filter((i) -> (!(i.isDel()))).map((i) -> {
                JRadioButton tmpRadioButton = new JRadioButton(i.getSnakeName());
                Controller.snakedHashed.put(tmpRadioButton, i);
                return tmpRadioButton;
            }).map((tmpRadioButton) -> {
                buttongroup.add(tmpRadioButton);
                return tmpRadioButton;
            }).forEach((tmpRadioButton) -> {
                removingDialg.add(tmpRadioButton);
            });

            removingDialg.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    Controller.snakedHashed.entrySet().removeIf(e -> {
                        JRadioButton snakeButton = e.getKey();
                        if (snakeButton.isSelected()) {
                            Snake deletedSnake = Controller.snakedHashed.get(snakeButton);
                            deletedSnake.setIsSnakeDeleted(true);
                            return true;
                        }
                        return false;
                    });
                }
            });
            removingDialg.setVisible(true);
        });
    }
    
}

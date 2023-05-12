package Views;


import Models.Snake;
import Controllers.Controller;
import Resources.LanguageOptions;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewSnake {

    int snakesId = 1;
    String tmpLange;
    String tmpKopfes;
    String tmpColor;
    String tmpName;

    public AddNewSnake(JFrame viewFrame , JMenuItem newSnake) {
        newSnake.addActionListener((ActionEvent e) -> {
            JDialog addingDialog = new JDialog(viewFrame);
            addingDialog.setLayout(new GridLayout(5, 1));
            JPanel first4rowsPanel = new JPanel();
            first4rowsPanel.setLayout(new GridLayout(4, 2));

            JLabel NameLabel = new JLabel(LanguageOptions.addNewSnakeOptions[Controller.getProgramLanguage()][0]);
            JLabel tLengthLabel = new JLabel(LanguageOptions.addNewSnakeOptions[Controller.getProgramLanguage()][1]);
            JLabel headsLabel = new JLabel(LanguageOptions.addNewSnakeOptions[Controller.getProgramLanguage()][2]);
            JLabel colorLabel = new JLabel(LanguageOptions.addNewSnakeOptions[Controller.getProgramLanguage()][3]);
            
            JTextField nameField = new JTextField();
            JTextField tLengthField = new JTextField();
            JTextField headsField = new JTextField();
            JComboBox colorList = new JComboBox(LanguageOptions.listOfColors[Controller.getProgramLanguage()]);
            JButton okayButton = new JButton("OK");

            JPanel row1Panel = new JPanel(new GridLayout(1, 2));
            row1Panel.add(NameLabel);
            row1Panel.add(nameField);
            JPanel row2Panel = new JPanel(new GridLayout(1, 2));
            row2Panel.add(tLengthLabel);
            row2Panel.add(tLengthField);
            JPanel row3Panel = new JPanel(new GridLayout(1, 2));
            row3Panel.add(headsLabel);
            row3Panel.add(headsField);
            JPanel row4Panel = new JPanel(new GridLayout(1, 2));
            row4Panel.add(colorLabel);
            row4Panel.add(colorList);
            JPanel row5Panel = new JPanel(new GridLayout(1, 2));
            row5Panel.add(okayButton);
            addingDialog.add(row1Panel);
            addingDialog.add(row2Panel);
            addingDialog.add(row3Panel);
            addingDialog.add(row4Panel);
            addingDialog.add(row5Panel);
            addingDialog.setLocation(200, 200);
            addingDialog.pack();
            addingDialog.setVisible(true);

            okayButton.addActionListener((ActionEvent event) -> {
                tmpName = nameField.getText();
                tmpLange = tLengthField.getText();
                tmpKopfes = headsField.getText();
                tmpColor = colorList.getSelectedItem().toString();

                boolean cond0, cond1, cond2, cond3;
                cond0 = false;
                cond1 = false;
                cond2 = false;
                cond3 = false;
                if (!(cond0 && cond1 && cond2 && cond3)) {
                    if (!Controller.isNameEmpty(tmpName)) {
                        Controller.errorInputFixing(0);
                    } else {
                        cond0 = true;
                    }

                    if (!Controller.isInteger(tmpLange)) {
                        Controller.errorInputFixing(1);
                    } else {
                        cond1 = true;
                    }

                    if (!Controller.isInteger(tmpKopfes)) {
                        Controller.errorInputFixing(2);
                    } else {
                        cond2 = true;
                    }

                    if (!Controller.isLargerOrEqual(tmpLange, tmpKopfes)) {
                        Controller.errorInputFixing(3);
                    } else {
                        cond3 = true;
                    }
                }//
                if (cond0 && cond1 && cond2 && cond3) {
                    Snake s = new Snake(snakesId++, tmpName, Integer.parseInt(tmpLange), Integer.parseInt(tmpKopfes), Controller.stringToColor(tmpColor), Controller.gamePanel.getDim(0), Controller.gamePanel.getDim(1));
                    Controller.snakes.add(s);
                    addingDialog.dispose();
                }

            });

        });


    }

}

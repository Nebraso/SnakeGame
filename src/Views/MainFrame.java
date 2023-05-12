package Views;


import Controllers.Controller;
import Resources.LanguageOptions;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.*;
import java.util.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        Controller.gamePanel = new SnakePanel();
        JFrame viewFrame = new JFrame(LanguageOptions.title[Controller.getProgramLanguage()]);
        viewFrame.setLocation(300, 300);
        viewFrame.setSize(750, 500);
        viewFrame.setLayout(new BorderLayout());

        JMenu Action = new JMenu(LanguageOptions.menu[0][Controller.getProgramLanguage()]);
        JMenuItem newSnake = new JMenuItem(LanguageOptions.actionItems[Controller.getProgramLanguage()][0]);
        newSnake.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        Action.add(newSnake);
        JMenuItem deleteSnake = new JMenuItem(LanguageOptions.actionItems[Controller.getProgramLanguage()][1]);
        deleteSnake.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        Action.add(deleteSnake);
        JMenuItem exit = new JMenuItem(LanguageOptions.actionItems[Controller.getProgramLanguage()][2]);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        Action.add(exit);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Action);
        viewFrame.setJMenuBar(menuBar);

        new AddNewSnake(viewFrame, newSnake);
        new RemoveSnake(viewFrame, deleteSnake);
        new Closing(viewFrame, exit);
        new WindowClosing(viewFrame);

        Controller.gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (null != Controller.gamePanel) {
                    Controller.gamePanel.setDim(Controller.gamePanel.getSize());
                }
            }
        });

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BorderLayout());

        JPanel rPanel = new JPanel();
        JLabel langsamPanel = new JLabel(LanguageOptions.sliderLabels[Controller.getProgramLanguage()][0]);
        JLabel SchnellerPanel = new JLabel(LanguageOptions.sliderLabels[Controller.getProgramLanguage()][1]);
        rPanel.add(SchnellerPanel);
        JToggleButton startStopButton = new JToggleButton(LanguageOptions.startStop[Controller.getProgramLanguage()], true);
        rPanel.add(startStopButton);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 75);
        optionsPanel.add(langsamPanel, BorderLayout.WEST);
        optionsPanel.add(slider, BorderLayout.CENTER);
        optionsPanel.add(rPanel, BorderLayout.EAST);

        startStopButton.addItemListener((ItemEvent event) -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                Controller.gamePanel.setIsRunning(true);
            } else if (event.getStateChange() == ItemEvent.DESELECTED) {
                Controller.gamePanel.setIsRunning(false);
            }
            //    comb.addItemListener((ItemListener) new ItemListener() {

        });

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(25);

        slider.addChangeListener((ChangeEvent event) -> {
            JSlider slider1 = (JSlider) event.getSource();
            if (!slider1.getValueIsAdjusting()) {
                Controller.gamePanel.setNewTimerSpeed(Controller.numToMs(slider1.getValue(), 100, 0, 2000, 1));
            }
        });
        viewFrame.add(Controller.gamePanel);
        viewFrame.add(optionsPanel, BorderLayout.SOUTH);
        viewFrame.setVisible(true);

    }

}

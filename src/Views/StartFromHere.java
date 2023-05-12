package Views;

import Controllers.Controller;
import Resources.LanguageOptions;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StartFromHere {

    public StartFromHere() {
        JFrame frame = new JFrame("Select Language");
        frame.setSize(350, 300);
        frame.setLocation(500, 500);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Container c = frame.getContentPane();
         c.setLayout(null);
         
        JLabel label = new JLabel("Language: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setSize(100, 40);
        label.setLocation(50, 100);
        c.add(label);

        JComboBox box = new JComboBox(LanguageOptions.langaugeOptions);
        box.setFont(new Font("Arial", Font.PLAIN, 15));
        box.setSize(100, 40);
        box.setLocation(150, 100);
        c.add(box);
        
        box.addActionListener(event -> {
            Controller.setProgramLanguage(box.getSelectedItem().toString());
            new MainFrame();
            frame.dispose();
        });
        
        frame.setVisible(true);
        /*frame.setUndecorated(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        */
    }

    public static void main(String[] args) {
        new StartFromHere();
    }
}

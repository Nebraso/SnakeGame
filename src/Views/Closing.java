package Views;


import Controllers.Controller;
import Resources.LanguageOptions;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;


public class Closing {

    public Closing(JFrame viewFrame, JMenuItem exit) {
        exit.addActionListener((ActionEvent event) -> {
            int closemsgvalue = Controller.closingValue(viewFrame, LanguageOptions.ClosingMessage[Controller.getProgramLanguage()], LanguageOptions.YesOrNo[Controller.getProgramLanguage()]);
            if (closemsgvalue == 0) {
                System.exit(0);
            }

        });
    }
    
}

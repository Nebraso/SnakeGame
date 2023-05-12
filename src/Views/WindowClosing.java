package Views;


import Controllers.Controller;
import Resources.LanguageOptions;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


public class WindowClosing {

    public WindowClosing(JFrame viewFrame) {
        viewFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int closemsmvalue = Controller.closingValue(viewFrame, LanguageOptions.ClosingMessage[Controller.getProgramLanguage()], LanguageOptions.YesOrNo[Controller.getProgramLanguage()]);
                if (closemsmvalue == 0) {
                    System.exit(0);
                } else {
                    viewFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    
}

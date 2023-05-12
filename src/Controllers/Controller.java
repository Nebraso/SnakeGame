package Controllers;

import Views.SnakePanel;
import Models.Snake;
import Resources.LanguageOptions;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Controller {

    public static ArrayList<Snake> snakes = new ArrayList<>();
    public static HashMap<JRadioButton, Snake> snakedHashed = new HashMap<>();
    public static SnakePanel gamePanel;
    private static int programLanguage;

    public static void setProgramLanguage(String programLanguage) {

        if ("English".equals(programLanguage)) {
            Controller.programLanguage = 0;
        }
        if ("Deutsch".equals(programLanguage)) {
            Controller.programLanguage = 1;
        } else if ("Русский".equals(programLanguage)) {
            Controller.programLanguage = 2;
        }

    }

    public static int getProgramLanguage() {
        return programLanguage;
    }

    public static boolean isNameEmpty(String s) {
        return !s.isEmpty();
    }

    public static boolean isInteger(String inputString) {
        boolean flag = false;
        if (inputString.isEmpty()) {
            return flag;
        }
        try {
            Integer.parseInt(inputString);
            flag = true;
            return flag;
        } catch (Exception error) {
            return flag;
        }
    }

    public static void errorInputFixing(int numOfErr) {
        JOptionPane.showMessageDialog(null, LanguageOptions.listOfErrorMessages[getProgramLanguage()][numOfErr]);
    }

    public static int closingValue(JFrame frm, String closemsg, Object[] closingOptions) {
        return JOptionPane.showOptionDialog(frm, closemsg, LanguageOptions.ClosingPanelTitle[Controller.getProgramLanguage()], JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, closingOptions, closingOptions[1]);
    }

    public static boolean isLargerOrEqual(String tmpTL, String TmpHl) {
        boolean allCondMet = false;
        boolean firstCheck = Integer.parseInt(tmpTL) >= Integer.parseInt(TmpHl);
        boolean secondCheck = Integer.parseInt(tmpTL) > 0;
        boolean thirdCheck = Integer.parseInt(TmpHl) > 0;
        if (firstCheck && secondCheck && thirdCheck) {
            allCondMet = true;
        }
        return allCondMet;
    }

    public static Color stringToColor(String color) {
        Color c;
        if ("Red".equals(color) || "Rot".equals(color) || "Красный".equals(color)) {
            c = Color.RED;
        } else if ("Black".equals(color) || "Schwarz".equals(color) || "черный".equals(color)) {
            c = Color.BLACK;
        } else if ("Yellow".equals(color) || "Gelb".equals(color) || "Желтый".equals(color)) {
            c = Color.YELLOW;
        } else if ("Green".equals(color) || "Grün".equals(color) || "Зеленый".equals(color)) {
            c = Color.GREEN;
        } else if ("Blue".equals(color) || "Blau".equals(color) || "Синий".equals(color)) {
            c = Color.BLUE;
        } else if ("Magenta".equals(color) || "Пурпурный".equals(color)) {
            c = Color.MAGENTA;
        } else {
            c = Color.CYAN;
        }

        return c;
    }

    public static int getSnakeNumber(ArrayList<Snake> list) {
        int cnt=0;
        for (Snake i : list){
             if(!(i.isDel()))cnt++;
         }
        return cnt;
    }

    public static int generateNumber(int hi, int lw) {

        return (int) (Math.random() * (hi - lw)) + lw;
    }

    public static int isOutOfBoundsAndKnowWhere(int x, int y, int xmx, int ymx) {

        if (x <= 0) {
            return 1;
        }
        if (x >= xmx) {
            return 2;
        }
        if (y <= 0) {
            return 3;
        }
        if (y >= ymx) {
            return 4;
        }
        return 0;
    }

    public static int adjustOutOfBoundsCorr(int point, int xmx, int ymx) {
        int sol;
        switch (point) {
            case 1:
                sol = xmx - 2;
                break;
            case 2:
                sol = 2;
                break;
            case 3:
                sol = ymx - 2;
                break;
            default:
                sol = 2;
                break;
        }
        return sol;

    }

    public static int numToMs(int alt_Wert, int altMx, int altmin, int newRangeMax, int newRangMin) {
        int ans, a, b, c;
        if (alt_Wert == 0) {
            ans = 5000000;
            return ans;
        }
        a = alt_Wert - altmin;
        b = newRangeMax - newRangMin;
        c = altMx - altmin;
        int NewValue = (a * b / c) + newRangMin;
        ans = newRangeMax - NewValue;
        return ans;
    }
}

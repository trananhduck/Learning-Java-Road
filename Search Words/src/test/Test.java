package test;

import javax.swing.UIManager;
import view.TimKiemView;

public class Test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new TimKiemView();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

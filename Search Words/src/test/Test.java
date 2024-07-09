package test;

import java.awt.HeadlessException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.TimKiemView;

public class Test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new TimKiemView();
        } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }
    }
}

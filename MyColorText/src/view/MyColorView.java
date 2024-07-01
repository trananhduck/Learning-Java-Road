package view;

import controller.MyColorListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.MyColorModel;

public class MyColorView extends JFrame {
    private MyColorModel myColorModel;
    private JLabel jLabel;

    public MyColorView() {
        this.myColorModel = new MyColorModel();
        this.init();
    }

    public void init() {
        this.setTitle("My Color");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font text_font = new Font("Arial", Font.BOLD, 60);
        MyColorListener myColorListener = new MyColorListener(this);

        jLabel = new JLabel("Anh Duc Tran");
        jLabel.setFont(text_font);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 3));
        Font font = new Font("Arial", Font.BOLD, 20);
        JButton jButton_text_red = new JButton("Red Text");
        jButton_text_red.setFont(font);
        jButton_text_red.setForeground(Color.RED);
        jButton_text_red.addActionListener(myColorListener);

        JButton jButton_text_yellow = new JButton("Yellow Text");
        jButton_text_yellow.setFont(font);
        jButton_text_yellow.setForeground(Color.YELLOW);
        jButton_text_yellow.addActionListener(myColorListener);

        JButton jButton_text_green = new JButton("Green Text");
        jButton_text_green.setFont(font);
        jButton_text_green.setForeground(Color.GREEN);
        jButton_text_green.addActionListener(myColorListener);

        JButton jButton_bg_red = new JButton("Red Background");
        jButton_bg_red.setFont(font);
        jButton_bg_red.setBackground(Color.RED);
        jButton_bg_red.setOpaque(true);
        jButton_bg_red.addActionListener(myColorListener);

        JButton jButton_bg_yellow = new JButton("Yellow Background");
        jButton_bg_yellow.setFont(font);
        jButton_bg_yellow.setBackground(Color.YELLOW);
        jButton_bg_yellow.setOpaque(true);
        jButton_bg_yellow.addActionListener(myColorListener);

        JButton jButton_bg_green = new JButton("Green Background");
        jButton_bg_green.setFont(font);
        jButton_bg_green.setBackground(Color.GREEN);
        jButton_bg_green.setOpaque(true);
        jButton_bg_green.addActionListener(myColorListener);

        jPanel.add(jButton_text_red);
        jPanel.add(jButton_text_yellow);
        jPanel.add(jButton_text_green);
        jPanel.add(jButton_bg_red);
        jPanel.add(jButton_bg_yellow);
        jPanel.add(jButton_bg_green);

        this.setLayout(new BorderLayout());
        this.add(jLabel, BorderLayout.NORTH);
        this.add(jPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void changeTextColor(Color color) {
        this.jLabel.setForeground(color);
    }

    public void changeBgColor(Color color) {
        this.jLabel.setBackground(color);
        this.jLabel.setOpaque(true);

    }
}

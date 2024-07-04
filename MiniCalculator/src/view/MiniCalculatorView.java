package view;

import controller.MiniCalculatorListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.MiniCalculatorModel;

public class MiniCalculatorView extends JFrame {
    private MiniCalculatorModel miniCalculatorModel;
    private JLabel jLabel_firstValue;
    private JLabel jLabel_secondValue;
    private JLabel jLabel_answer;
    private JTextField jTextField_firstValue;
    private JTextField jTextField_secondValue;
    private JTextField jTextField_answer;

    public MiniCalculatorView() throws HeadlessException {
        this.miniCalculatorModel = new MiniCalculatorModel();
        this.init();
    }

    private void init() {
        this.setTitle("Mini Calculator");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.BOLD, 40);
        // Noi hien thi text
        jLabel_firstValue = new JLabel("1st Value");
        jLabel_firstValue.setFont(font);
        jLabel_secondValue = new JLabel("2nd Value");
        jLabel_secondValue.setFont(font);
        jLabel_answer = new JLabel();
        jLabel_answer.setFont(font);
        // Nhap du lieu
        jTextField_firstValue = new JTextField(50);
        jTextField_firstValue.setFont(font);
        jTextField_secondValue = new JTextField(50);
        jTextField_secondValue.setFont(font);
        jTextField_answer = new JTextField(50);
        jTextField_answer.setFont(font);
        this.setVisible(true);
        // Nhap va hien thi ket qua
        JPanel jPanelIO = new JPanel();
        jPanelIO.setLayout(new GridLayout(3, 2, 30, 30));
        jPanelIO.add(jLabel_firstValue);
        jPanelIO.add(jTextField_firstValue);
        jPanelIO.add(jLabel_secondValue);
        jPanelIO.add(jTextField_secondValue);
        jPanelIO.add(jLabel_answer);
        jPanelIO.add(jTextField_answer);

        // Them cac dau phep tinh
        MiniCalculatorListener miniCalculatorListener = new MiniCalculatorListener(this);
        JButton jButton_plus = new JButton("+");
        jButton_plus.setFont(font);
        jButton_plus.addActionListener(miniCalculatorListener);
        JButton jButton_minus = new JButton("-");
        jButton_minus.setFont(font);
        jButton_minus.addActionListener(miniCalculatorListener);
        JButton jButton_multiply = new JButton("+");
        jButton_multiply.setFont(font);
        jButton_multiply.addActionListener(miniCalculatorListener);
        JButton jButton_divide = new JButton("/");
        jButton_divide.setFont(font);
        jButton_divide.addActionListener(miniCalculatorListener);
        JButton jButton_pow = new JButton("^");
        jButton_pow.setFont(font);
        jButton_pow.addActionListener(miniCalculatorListener);
        JButton jButton_mod = new JButton("%");
        jButton_mod.setFont(font);
        jButton_mod.addActionListener(miniCalculatorListener);

        // Them cac nut vao Panel
        JPanel jPanelButtons = new JPanel();
        jPanelButtons.setLayout(new GridLayout(2, 3));
        jPanelButtons.add(jButton_plus);
        jPanelButtons.add(jButton_minus);
        jPanelButtons.add(jButton_multiply);
        jPanelButtons.add(jButton_divide);
        jPanelButtons.add(jButton_pow);
        jPanelButtons.add(jButton_mod);

        this.setLayout(new BorderLayout(10, 10));
        this.add(jPanelButtons, BorderLayout.SOUTH);
        this.add(jPanelIO, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void plus() {
        double firstValue = Double.valueOf(jTextField_firstValue.getText());
        double secondValue = Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFirstValue(firstValue);
        this.miniCalculatorModel.setSecondValue(secondValue);
        this.miniCalculatorModel.plus();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer() + "");
    }

    public void minus() {
        double firstValue = Double.valueOf(jTextField_firstValue.getText());
        double secondValue = Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFirstValue(firstValue);
        this.miniCalculatorModel.setSecondValue(secondValue);
        this.miniCalculatorModel.minus();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer() + "");
    }

    public void multiply() {
        double firstValue = Double.valueOf(jTextField_firstValue.getText());
        double secondValue = Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFirstValue(firstValue);
        this.miniCalculatorModel.setSecondValue(secondValue);
        this.miniCalculatorModel.multiply();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer() + "");
    }

    public void divide() {
        try {
            double firstValue = Double.parseDouble(jTextField_firstValue.getText());
            double secondValue = Double.parseDouble(jTextField_secondValue.getText());

            if (secondValue == 0) {
                jTextField_answer.setText("NULL");
                return;
            }

            this.miniCalculatorModel.setFirstValue(firstValue);
            this.miniCalculatorModel.setSecondValue(secondValue);
            this.miniCalculatorModel.divide();

            // Hiển thị kết quả chia với 5 chữ số thập phân
            String result = String.format("%.5f", this.miniCalculatorModel.getAnswer());
            this.jTextField_answer.setText(result);

        } catch (NumberFormatException e) {
            jTextField_answer.setText("Invalid input");
        }
    }

    public void pow() {
        double firstValue = Double.valueOf(jTextField_firstValue.getText());
        double secondValue = Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFirstValue(firstValue);
        this.miniCalculatorModel.setSecondValue(secondValue);
        this.miniCalculatorModel.pow();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer() + "");
    }

    public void mod() {
        try {
            double firstValue = Double.parseDouble(jTextField_firstValue.getText());
            double secondValue = Double.parseDouble(jTextField_secondValue.getText());

            if (secondValue == 0) {
                jTextField_answer.setText("NULL");
                return;
            }

            this.miniCalculatorModel.setFirstValue(firstValue);
            this.miniCalculatorModel.setSecondValue(secondValue);
            this.miniCalculatorModel.mod();

            String result = String.format("%.0f", this.miniCalculatorModel.getAnswer());
            this.jTextField_answer.setText(result);

        } catch (NumberFormatException e) {
            jTextField_answer.setText("Invalid input");
        }
    }
}

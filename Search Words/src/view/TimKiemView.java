package view;

import controller.TimKiemListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.TimKiemModel;

public class TimKiemView extends JFrame {
    private final TimKiemModel timKiemModel;
    private JLabel jLabel_ketQua;
    private JTextArea jTextArea_vanban;
    private JTextField jTextField_tukhoa;

    public TimKiemView() throws HeadlessException {
        this.timKiemModel = new TimKiemModel();
        this.init();
    }

    private void init() {
        this.setTitle("Tim Kiem");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Arial", Font.BOLD, 40);

        // Center Panel
        JLabel jLabel_vanBan = new JLabel("Van ban");
        jLabel_vanBan.setFont(font);
        jTextArea_vanban = new JTextArea(10, 50); // Sửa kích thước để hợp lý hơn
        jTextArea_vanban.setFont(font);

        JScrollPane jScrollPane = new JScrollPane(jTextArea_vanban, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Footer
        TimKiemListener timKiemListener = new TimKiemListener(this);

        JLabel jLabel_tukhoa = new JLabel("Tu Khoa");
        jLabel_tukhoa.setFont(font);
        jTextField_tukhoa = new JTextField();
        jTextField_tukhoa.setFont(font);

        JButton jButton_thongKe = new JButton("Thong ke");
        jButton_thongKe.setFont(font);
        jButton_thongKe.addActionListener(timKiemListener);
        jButton_thongKe.setBackground(Color.BLUE); // Đổi màu nút bấm

        jLabel_ketQua = new JLabel();
        jLabel_ketQua.setBackground(Color.YELLOW);
        jLabel_ketQua.setFont(font);
        jLabel_ketQua.setOpaque(true); // Cần thiết để hiển thị màu nền của JLabel

        JPanel jPanel_footer = new JPanel();
        jPanel_footer.setLayout(new GridLayout(2, 2));
        jPanel_footer.add(jLabel_tukhoa);
        jPanel_footer.add(jTextField_tukhoa);
        jPanel_footer.add(jButton_thongKe);
        jPanel_footer.add(jLabel_ketQua);

        this.setLayout(new BorderLayout());
        this.add(jLabel_vanBan, BorderLayout.NORTH);
        this.add(jScrollPane, BorderLayout.CENTER); // Thêm JScrollPane vào JFrame
        this.add(jPanel_footer, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void timKiem() {
        this.timKiemModel.setVanBan(jTextArea_vanban.getText());
        this.timKiemModel.setTuKhoa(jTextField_tukhoa.getText());
        this.timKiemModel.timKiem();
        this.jLabel_ketQua.setText(this.timKiemModel.getKetQua());
    }
}

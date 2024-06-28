package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CounterView;

//day la mot interface
public class CounterListener implements ActionListener {
    private CounterView ctv;

    public CounterListener(CounterView ctv) {
        this.ctv = ctv;
    }

    // dung de "lang nghe" cac thao tac cua nguoi dung
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println("ban da nhan nut");
        if (src.equals("UP")) {
            this.ctv.increment();
        } else if (src.equals("DOWN")) {
            this.ctv.decrement();
        } else if (src.equals("RESET")) {
            this.ctv.reset();
        }
    }
}

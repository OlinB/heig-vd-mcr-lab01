package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(Dial dial) {
        this.repaint();
        add(dial.getPanel());
        setVisible(true);
        setResizable(false);
        pack();
    }

    public Window(Dial[] dials) {
        setLayout(new FlowLayout());
        for (Dial dial : dials) {
            add(dial.getPanel());
        }

        setVisible(true);
        pack();
    }
}

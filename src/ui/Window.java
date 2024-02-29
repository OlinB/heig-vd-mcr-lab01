package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(JPanel panel) {
        this.repaint();
        add(panel);
        setSize(200, 200);
        setVisible(true);
    }

    public Window(JPanel[] panels) {
        setLayout(new GridLayout(panels.length,  1));
        for (JPanel panel : panels) {
            add(panel);
        }
        setSize(200, 200);
        setVisible(true);
    }
}

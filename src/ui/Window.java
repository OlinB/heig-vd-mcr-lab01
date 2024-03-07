package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(Dial dial) {
        this.repaint();
        add(dial.getPanel());
        setSize(200, 200);
        setVisible(true);
    }

    public Window(Dial[] dials) {
        setLayout(new GridLayout(dials.length,  1));
        for (Dial dial : dials) {
            add(dial.getPanel());
        }
        setSize(200, 200);
        setVisible(true);
    }
}

package ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(Dial dial) {
        this.repaint();
        add(dial.getPanel());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt){
                dial.getChrono().detach(dial);
            }
        });

        setVisible(true);
        setResizable(false);
        pack();
    }

    public Window(Dial[] dials) {
        setLayout(new FlowLayout());
        for (Dial dial : dials) {
            add(dial.getPanel());
        }

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt){
                for (Dial dial : dials) {
                    dial.getChrono().detach(dial);
                }
            }
        });

        setVisible(true);
        pack();
    }
}

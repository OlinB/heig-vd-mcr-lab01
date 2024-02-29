package ui;

import ui.Dial;

import javax.swing.*;
import java.awt.*;

public class DialManager extends JFrame {

    public DialManager(int nbDials) {
        super("Panneau de contrôle");
        setLayout(new GridLayout(nbDials + 1, 1));
        for (int i = 0; i < nbDials; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            // label
            JLabel label = new JLabel("Chrono #" + i);
            panel.add(label);

            // buttons

            add(panel);

        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

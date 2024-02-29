package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialManager extends JFrame {

    private static final String[] BUTTONS_DIAL = {"démarrer", "arrêter", "réinitialiser", "cadran romain", "cadran arabe", "numérique"};
    private static final String[] BUTTONS_ALL = {"cadran romain", "cadran arabe", "numérique"};

    public DialManager(int nbDials) {
        super("Panneau de contrôle");
        setLayout(new GridLayout(nbDials + 1, 1));
        for (int i = 0; i < nbDials; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            // label
            JLabel label = new JLabel("Chrono #" + i);
            panel.add(label);

            // buttons
            for (String text : BUTTONS_DIAL) {
                JButton button = new JButton(text);
                button.addActionListener(e -> System.out.println("Button " + text + " clicked"));
                panel.add(button);
            }

            add(panel);


        }
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // label
        JLabel label = new JLabel("Tous les chronos");
        panel.add(label);

        for (String text : BUTTONS_ALL) {
            JButton button = new JButton(text);
            button.addActionListener(e -> System.out.println("Button " + text + " clicked"));
            panel.add(button);
        }
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

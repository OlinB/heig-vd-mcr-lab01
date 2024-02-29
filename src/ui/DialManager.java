package ui;

import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public class DialManager extends JFrame {

    private static final String[] BUTTONS_DIAL = {"démarrer", "arrêter", "réinitialiser", "cadran romain", "cadran arabe", "numérique"};
    private static final String[] BUTTONS_ALL = {"cadran romain", "cadran arabe", "numérique"};

    private Chrono[] chronos;

    public DialManager(int nbChronos) {
        super("Panneau de contrôle");

        chronos = new Chrono[nbChronos];

        setLayout(new GridLayout(nbChronos + 1, 1));

        for (int i = 0; i < nbChronos; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            // label
            JLabel label = new JLabel("Chrono #" + i);
            panel.add(label);

            // buttons
            for (String text : BUTTONS_DIAL) {
                JButton button = new JButton(text);
                int finalI = i;
                button.addActionListener(e -> doAction(finalI, text));
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
            button.addActionListener(e -> doAction(text));
            panel.add(button);
        }

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void doAction(int chronoID, String action) {
        System.out.println("Chrono #" + chronoID + " " + action);
    }

    private void doAction(String action) {
        System.out.println("All chronos " + action);
    }
}

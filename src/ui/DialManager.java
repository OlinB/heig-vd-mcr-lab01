package ui;

import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public class DialManager extends JFrame {

    private static final String[] BUTTONS_DIAL = {"cadran romain", "cadran arabe", "numérique"};
    private static final String[] BUTTONS_ALL = {"cadran romain", "cadran arabe", "numérique"};

    private final Chrono[] chronos;

    public DialManager(int nbChronos) {
        super("Panneau de contrôle");

        chronos = new Chrono[nbChronos];

        for (int i = 0; i < nbChronos; i++) {
            chronos[i] = new Chrono();
        }

        setLayout(new GridLayout(nbChronos + 1, 1));

        for (int i = 0; i < nbChronos; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            // label
            JLabel label = new JLabel("Chrono #" + i);
            panel.add(label);

            int finalI = i;

            JButton startButton = new JButton("démarrer");
            startButton.addActionListener(e -> chronos[finalI].start());
            panel.add(startButton);

            JButton stopButton = new JButton("arrêter");
            stopButton.addActionListener(e -> chronos[finalI].stop());
            panel.add(stopButton);

            JButton resetButton = new JButton("réinitialiser");
            resetButton.addActionListener(e -> chronos[finalI].reset());
            panel.add(resetButton);

            // buttons
            for (String text : BUTTONS_DIAL) {
                JButton button = new JButton(text);
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

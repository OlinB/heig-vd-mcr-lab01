package ui;

import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public class DialManager extends JFrame {

    private final Chrono[] chronos;

    public DialManager(int nbChronos) {
        super("Panneau de contrôle");

        chronos = new Chrono[nbChronos];

        for (int i = 0; i < nbChronos; i++) {
            chronos[i] = new Chrono(i + 1);
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

            JButton romanButton = new JButton(RomanDial.BUTTON_NAME);
            romanButton.addActionListener(e -> new Window(new RomanDial(chronos[finalI])));
            panel.add(romanButton);

            JButton arabButton = new JButton(ArabDial.BUTTON_NAME);
            arabButton.addActionListener(e -> new Window(new ArabDial(chronos[finalI])));
            panel.add(arabButton);

            JButton digitalButton = new JButton(DigitalDial.getButtonName());
            digitalButton.addActionListener(e ->new Window(new DigitalDial(chronos[finalI])));
            panel.add(digitalButton);

            add(panel);
        }

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // label
        JLabel label = new JLabel("Tous les chronos");
        panel.add(label);

        JButton romanButton = new JButton(RomanDial.BUTTON_NAME);
        romanButton.addActionListener(e -> createDials(RomanDial.BUTTON_NAME));
        panel.add(romanButton);

        JButton arabButton = new JButton(ArabDial.BUTTON_NAME);
        arabButton.addActionListener(e -> createDials(ArabDial.BUTTON_NAME));
        panel.add(arabButton);

        JButton digitalButton = new JButton(DigitalDial.getButtonName());
        digitalButton.addActionListener(e -> createDials(DigitalDial.getButtonName()));
        panel.add(digitalButton);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    private void createDials(String action) {
        // create dials for all chronos
        Dial[] dials = new Dial[chronos.length];
        for (int i = 0; i < chronos.length; i++) {
            switch (action) {
                case RomanDial.BUTTON_NAME:
                    dials[i] = new RomanDial(chronos[i]);
                    break;
                case ArabDial.BUTTON_NAME:
                    dials[i] = new ArabDial(chronos[i]);
                    break;
                case DigitalDial.BUTTON_NAME:
                    dials[i] = new DigitalDial(chronos[i]);
                    break;
                default:
                    throw new IllegalArgumentException("Action not supported: " + action);
            }
        }
        new Window(dials);
    }
}

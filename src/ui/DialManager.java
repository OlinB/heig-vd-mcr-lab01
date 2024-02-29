package ui;

import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public class DialManager extends JFrame {

    private Chrono[] chronos;

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

            JButton romanButton = new JButton(RomanDial.getButtonName());
            romanButton.addActionListener(e -> new Window(new RomanDial(chronos[finalI]).getPanel(1)));
            panel.add(romanButton);

            JButton arabButton = new JButton(ArabDial.getButtonName());
            arabButton.addActionListener(e -> new Window(new ArabDial(chronos[finalI]).getPanel(1)));
            panel.add(arabButton);

            JButton digitalButton = new JButton(DigitalDial.getButtonName());
            digitalButton.addActionListener(e ->new Window(new DigitalDial(chronos[finalI]).getPanel(1)));
            panel.add(digitalButton);

            add(panel);
        }

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // label
        JLabel label = new JLabel("Tous les chronos");
        panel.add(label);

        JButton romanButton = new JButton(RomanDial.getButtonName());
        romanButton.addActionListener(e -> doAction(RomanDial.getButtonName()));
        panel.add(romanButton);

        JButton arabButton = new JButton(ArabDial.getButtonName());
        arabButton.addActionListener(e -> doAction(ArabDial.getButtonName()));
        panel.add(arabButton);

        JButton digitalButton = new JButton(DigitalDial.getButtonName());
        digitalButton.addActionListener(e -> doAction(DigitalDial.getButtonName()));
        panel.add(digitalButton);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public DialManager(Chrono[] chronos) {
        this.chronos = chronos;
    }

    private void doAction(String action) {
        System.out.println("All chronos " + action);
    }
}

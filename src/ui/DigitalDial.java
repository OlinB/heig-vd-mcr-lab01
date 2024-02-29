package ui;

import chrono.BaseDial;
import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public class DigitalDial extends Dial {

    private final JPanel panel;

    public DigitalDial(Chrono chrono) {
        super(chrono);
        // Add an image to the frame
        panel = getPanel(1);
    }

    public void display() {
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    @Override
    public void update() {
        super.update();
        panel.repaint();
    }

    public static String getButtonName() {
        return "Numérique";
    }

    public JPanel getPanel(int nbDials) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < nbDials; i++) {
                    g.drawString(getHours() + ":" + getMinutes() + ":" + getSeconds(), i * 200 + 100, 100);
                }
            }
        };
    }

}

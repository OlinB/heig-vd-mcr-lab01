package ui;

import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public class DigitalDial extends Dial {

    public DigitalDial(Chrono chrono) {
        super(chrono);
        // Add an image to the frame
        panel = createPanel();
    }

    public static String getButtonName() {
        return "Numérique";
    }

    public JPanel createPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(getHours() + ":" + getMinutes() + ":" + getSeconds(), 200 + 100, 100);

            }
        };
    }

}

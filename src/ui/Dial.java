package ui;

import chrono.BaseDial;
import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public abstract class Dial extends BaseDial {

    private final JPanel panel;

    public Dial(Chrono chrono) {
        super(chrono);
        // Add an image to the frame
        panel = getPanel(1);
    }

    @Override
    public void update() {
        super.update();
        panel.repaint();
    }

    public abstract JPanel getPanel(int nbDials);

}

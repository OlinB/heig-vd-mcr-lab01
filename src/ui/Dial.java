package ui;

import chrono.BaseDial;
import chrono.Chrono;

import javax.swing.*;

public abstract class Dial extends BaseDial {

    protected JPanel panel;

    public Dial(Chrono chrono) {
        super(chrono);
        // Add an image to the frame
        panel = createPanel();
    }

    @Override
    public void update() {
        super.update();
        panel.repaint();
    }

    protected abstract JPanel createPanel();

    public JPanel getPanel() {
        return panel;
    }

}

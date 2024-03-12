package ui;

import chrono.BaseDial;
import chrono.Chrono;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Dial extends BaseDial {

    protected JPanel panel;
    protected JLabel label;

    public Dial(Chrono chrono) {
        super(chrono);
        panel = createPanel();
        addMouseListener();
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

    private void addMouseListener() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chrono.toggle();
            }
        });
    }

}

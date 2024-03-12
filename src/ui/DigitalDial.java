package ui;

import chrono.Chrono;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DigitalDial extends Dial {


    public final static String BUTTON_NAME = "Numérique";
    private final int chronoId;

    public DigitalDial(Chrono chrono) {
        super(chrono);

        chronoId = chrono.getId();

        label = new JLabel("Chrono #" + chronoId + ": " + String.format("%02d", getHours()) + " " + String.format("%02d", getMinutes()) + "m " + String.format("%02d", getSeconds()) + "s", JLabel.CENTER);
    }

    @Override
    public void update() {
        label.setText("Chrono #" + chronoId + ": " + String.format("%02d", getHours()) + " " + String.format("%02d", getMinutes()) + "m " + String.format("%02d", getSeconds()) + "s");
        super.update();
    }

    public static String getButtonName() {
        return BUTTON_NAME;
    }

    protected JPanel createPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setSize(200, 200);
                setLayout(new GridLayout());
                setBorder(new LineBorder(Color.BLACK, 2));
                this.add(label);
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
    }

}

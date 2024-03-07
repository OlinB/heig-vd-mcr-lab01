package ui;

import chrono.Chrono;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DigitalDial extends Dial {


    public final static String buttonName = "Numérique";

    private JLabel label;
    private final int chronoId;

    public DigitalDial(Chrono chrono) {
        super(chrono);

        chronoId = chrono.getId();

        label = new JLabel("Chrono #" + chronoId + ": " + String.format("%02d", getHours()) + " " + String.format("%02d", getMinutes()) + "m " + String.format("%02d", getSeconds()) + "s");
        panel = createPanel();
    }

    @Override
    public void update() {
        label.setText("Chrono #" + chronoId + ": " + String.format("%02d", getHours()) + " " + String.format("%02d", getMinutes()) + "m " + String.format("%02d", getSeconds()) + "s");
        super.update();
    }

    public static String getButtonName() {
        return buttonName;
    }

    public JPanel createPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setSize(200, 200);
                setLayout(new FlowLayout());
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

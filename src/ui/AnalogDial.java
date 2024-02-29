package ui;

import chrono.BaseDial;
import chrono.Chrono;

import javax.swing.*;
import java.awt.*;

public abstract class AnalogDial extends Dial {

    private final Image image;

    private final JPanel panel;

    public AnalogDial(Chrono chrono) {
        super(chrono);
        // Add an image to the frame
        image = getImage();
        panel = getPanel(1);
    }

    protected abstract Image getImage();

    protected Color getSecondsColor() {
        return Color.RED;
    }

    protected Color getMinutesColor() {
        return Color.BLUE;
    }

    protected Color getHoursColor() {
        return Color.BLACK;
    }

    protected int getSecondsLength() {
        return 80;
    }

    protected int getMinutesLength() {
        return 80;
    }

    protected int getHoursLength() {
        return 60;
    }

    protected int getSecondsWidth() {
        return 1;
    }

    protected int getMinutesWidth() {
        return 3;
    }

    protected int getHoursWidth() {
        return 5;
    }


    public JPanel getPanel(int nbDials) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < nbDials; i++) {
                    g.drawImage(image, 0, i * 200, this);
                    drawSecondsHand(g, i);
                    drawMinutesHand(g, i);
                    drawHoursHand(g, i);
                }
            }
        };
    }

    private void drawHand(Graphics g, double angle, int length, int width, Color color, int i){
        int x = (int) (i *200 + 100 + length * Math.sin(angle));
        int y = (int) (100 - length * Math.cos(angle));
        g.setColor(color);
        g.drawLine(i *200 + 100, 100, x, y);
    }

    private void drawSecondsHand(Graphics g, int i) {
        drawHand(g, Math.toRadians(this.getSeconds() * 6), getSecondsLength(), getSecondsWidth(), getSecondsColor(), i);
    }

    private void drawMinutesHand(Graphics g, int i) {
        drawHand(g, Math.toRadians(this.getMinutes() * 6), getMinutesLength(), getMinutesWidth(), getMinutesColor(), i);
    }

    private void drawHoursHand(Graphics g, int i) {
        drawHand(g, Math.toRadians(this.getHours() * 30 + this.getMinutes() / 2), getHoursLength(), getHoursWidth(), getHoursColor(), i);
    }

}

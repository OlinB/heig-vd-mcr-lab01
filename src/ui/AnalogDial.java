package ui;

import chrono.Chrono;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public abstract class AnalogDial extends Dial {

    private final Image image;

    public AnalogDial(Chrono chrono) {
        super(chrono);
        // Add an image to the frame
        image = getImage();
        panel = createPanel();
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


    public JPanel createPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                g2.drawImage(image, 0, 0, this);
                drawHoursHand(g2);
                drawMinutesHand(g2);
                drawSecondsHand(g2);

            }
        };
    }

    private void drawHand(Graphics2D g, double angle, int length, int width, Color color) {
        int x = (int) (100 + length * Math.sin(angle));
        int y = (int) (100 - length * Math.cos(angle));
        g.setColor(color);
        g.setStroke(new BasicStroke(width));
        g.draw(new Line2D.Double(100, 100, x, y));
    }

    private void drawSecondsHand(Graphics2D g) {
        drawHand(g, Math.toRadians(this.getSeconds() * 6), getSecondsLength(), getSecondsWidth(), getSecondsColor());
    }

    private void drawMinutesHand(Graphics2D g) {
        drawHand(g, Math.toRadians(this.getMinutes() * 6), getMinutesLength(), getMinutesWidth(), getMinutesColor());
    }

    private void drawHoursHand(Graphics2D g) {
        drawHand(g, Math.toRadians(this.getHours() * 30 + this.getMinutes() / 2), getHoursLength(), getHoursWidth(), getHoursColor());
    }

}

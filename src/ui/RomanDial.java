package ui;

import chrono.Chrono;

import java.awt.*;

public class RomanDial extends AnalogDial{


    public RomanDial(Chrono chrono) {
        super(chrono);
    }

    @Override
    protected Image getImage() {
        return Toolkit.getDefaultToolkit().getImage("images/cadran_chiffres_romains.jpg").getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    }

    @Override
    protected Color getSecondsColor() {
        return Color.ORANGE;
    }

    @Override
    protected Color getMinutesColor() {
        return Color.GRAY;
    }
}

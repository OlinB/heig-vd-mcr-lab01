package ui;

import chrono.Chrono;

import java.awt.*;

public class ArabDial extends AnalogDial {


    public final static String BUTTON_NAME = "Cadran arabe";


    public ArabDial(Chrono chrono) {
        super(chrono);
    }

    @Override
    protected Image getImage() {
        return Toolkit.getDefaultToolkit().getImage("images/cadran_chiffres_arabes.jpg").getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    }

    @Override
    protected Color getSecondsColor() {
        return Color.RED;
    }

    @Override
    protected Color getMinutesColor() {
        return Color.BLUE;
    }
}

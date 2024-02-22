package ui;

import ui.Dial;

import javax.swing.*;

public class DialManager {

    public DialManager(int nbDials) {

        JFrame frame = new JFrame("Chrono");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        for (int i = 0; i < nbDials; i++) {

                Dial dial = new Dial("images/cadran_chiffres_arabes.jpg");

                frame.add(dial.getPanel(nbDials));
        }



        frame.setSize(200,nbDials * 200);

        frame.setVisible(true);

    }
}

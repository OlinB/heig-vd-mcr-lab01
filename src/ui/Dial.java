package ui;

import javax.swing.*;
import java.awt.*;

public class Dial {

    private final Image image;

    public Dial(String imagePath) {
        // Add an image to the frame
        image = Toolkit.getDefaultToolkit().getImage(imagePath).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    }

    public JPanel getPanel(int nbDials) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < nbDials; i++) {
                    g.drawImage(image, 0, i * 200, this);

                }
            }
        };
    }

}

package chrono;

import observer.Subject;

import javax.swing.*;


public class Chrono extends Subject {

    private final Timer timer;

    public Chrono() {
        timer = new Timer(1000, e -> notifyObservers());
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void reset() {
        timer.restart();
    }
}



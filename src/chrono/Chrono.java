package chrono;

import observer.Observer;
import observer.Subject;

import javax.swing.*;


public class Chrono extends Subject {

    private final Timer timer;
    private int time = 0;

    public Chrono() {
        timer = new Timer(1000, e -> notifyObservers());
    }

    private void updateTime() {
        time++;
        notifyObservers();
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void reset() {
        timer.restart();
        time = 0;
    }

    public int getTime() {
        return time;
    }
}



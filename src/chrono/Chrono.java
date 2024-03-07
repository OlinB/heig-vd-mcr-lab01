package chrono;

import observer.Observer;
import observer.Subject;

import javax.swing.*;


public class Chrono extends Subject {

    private final Timer timer;
    private int time = 0;
    private final int id;

    public Chrono(int id) {
        timer = new Timer(10, e -> updateTime());
        this.id = id;
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
        time = 0;
    }

    public int getTime() {
        return time;
    }

    public int getId() {
        return id;
    }
}



package chrono;

import observer.Subject;

import javax.swing.*;

public class Chrono extends Subject {

    private final Timer timer;
    private int time = 0;
    private final int id;
    private boolean isRunning = false;

    public Chrono(int id) {
        timer = new Timer(1000, e -> updateTime());
        this.id = id;
    }

    private void updateTime() {
        time++;
        notifyObservers();
    }

    public void start() {
        timer.start();
        isRunning = true;
    }

    public void stop() {
        timer.stop();
        isRunning = false;
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

    public void toggle() {
        if (isRunning) {
            stop();
        } else {
            start();
        }
    }
}



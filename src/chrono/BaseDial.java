package chrono;

import observer.Observer;

public abstract class BaseDial extends Observer {

    private int time;
    private Chrono chrono;

    public BaseDial(Chrono chrono) {
        this.chrono = chrono;
        chrono.attach(this);
    }

    @Override
    public void update() {
        time = chrono.getTime();
        System.out.println("Time: " + getHours() + ":" + getMinutes() + ":" + getSeconds());
    }

    protected int getSeconds() {
        return time % 60;
    }

    protected int getMinutes() {
        return (time / 60) % 60;
    }

    protected int getHours() {
        return time / 3600;
    }
}

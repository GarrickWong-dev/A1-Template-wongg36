package ca.mcmaster.se2aa4.mazerunner.Refactor;

public class Marker extends Subject {
    private int state;
    public int getState() {
        return this.state;
    }

    public void setState(int state){
        this.state = state;
        this.notifyAllObservers();
    }
}
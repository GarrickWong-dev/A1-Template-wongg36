package ca.mcmaster.se2aa4.mazerunner.Refactor;

public class Marker extends Subject {

    Coordinates coords;
    Directions direction = Directions.RIGHT;
    int state;

    public Marker(Coordinates coords){
        this.coords = coords;
        setState(0);
    } 

    public int getState() {
        return this.state;
    }

    public void setState(int state){
        this.state = state;
        this.notifyAllObservers();
    }
}
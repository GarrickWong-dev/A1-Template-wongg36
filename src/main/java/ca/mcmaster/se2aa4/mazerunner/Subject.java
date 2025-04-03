package ca.mcmaster.se2aa4.mazerunner;
import java.util.*;

public abstract class Subject{
    public List<Observer> observers = new ArrayList<Observer>();
    protected int state;

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void detach(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : this.observers){
            observer.update();
        }
    }

    public int getState() {
        return this.state;
    }

    protected void setState(int state){
        this.state = state;
        this.notifyAllObservers();
    }

}
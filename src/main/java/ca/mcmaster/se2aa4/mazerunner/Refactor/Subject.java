package ca.mcmaster.se2aa4.mazerunner.Refactor;
import java.util.*;

public abstract class Subject{
    private List<Observer> observers = new ArrayList<Observer>();

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

}
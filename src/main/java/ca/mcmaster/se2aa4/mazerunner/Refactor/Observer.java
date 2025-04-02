package ca.mcmaster.se2aa4.mazerunner.Refactor;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
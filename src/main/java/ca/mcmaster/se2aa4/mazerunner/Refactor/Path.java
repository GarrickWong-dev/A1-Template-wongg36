package ca.mcmaster.se2aa4.mazerunner.Refactor;

public class Path extends Observer{
    public Path(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void update(){
        
    }
}
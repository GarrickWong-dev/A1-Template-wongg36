package ca.mcmaster.se2aa4.mazerunner.Refactor;

public class MakePath extends Observer{
    public MakePath(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void update(){
        
    }
}
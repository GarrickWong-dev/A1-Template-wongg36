package ca.mcmaster.se2aa4.mazerunner;
import java.util.*;
public class TestMovement extends Movement{
    public TestMovement(ArrayList<ArrayList<String>> maze){
        super(maze);
    }

    public void setStart(){
        this.coordinates[0] = 1;
        this.coordinates[1] = 1;
    }

    public int getX(){
        return this.coordinates[1];
    }

    public int getY(){
        return this.coordinates[0];
    }

    public void setDirection(String face){
        this.direction = face;
    }
}
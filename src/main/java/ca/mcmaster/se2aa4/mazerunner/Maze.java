package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class Maze{
    private ArrayList<ArrayList<String>> maze = new ArrayList<>();

    public Maze (ArrayList<ArrayList<String>> maze){
        this.maze = maze;
    }
    public ArrayList<ArrayList<String>> getMaze(){
        return this.maze;
    }
    
}

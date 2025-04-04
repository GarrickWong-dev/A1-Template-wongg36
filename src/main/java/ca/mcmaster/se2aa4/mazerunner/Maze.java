package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

//Stores the 2d array list for the maze
public class Maze{
    private ArrayList<ArrayList<Spot>> maze;
    protected Coordinates end = new Coordinates();
    protected Coordinates start = new Coordinates();

    //Initialized coordinates for start and end of maze
    public Maze (ArrayList<ArrayList<Spot>> maze){
        this.maze = maze;
        this.end.setX(maze.get(0).size()-1);
        this.start.setX(0);
        findStart();
        findEnd();


    }
    public ArrayList<ArrayList<Spot>> getMaze(){
        return this.maze;
    }

    private void findStart(){
        for (int i = 0; i < this.maze.size(); i++){
            if (this.maze.get(i).get(0) == Spot.PASS){
                this.start.setY(i);
            }
        }
    }

    private void findEnd(){
         for (int i = 0; i < this.maze.size(); i++){
             if (this.maze.get(i).get(this.maze.get(0).size()-1) == Spot.PASS){
                 this.end.setY(i);
             }
         }  
    }    

    public Coordinates getStart(){
        return this.start;
    }

    public Coordinates getEnd(){
        return this.end;
    }

    public Spot getSpot(int x, int y){
        return this.maze.get(y).get(x);
    }
}
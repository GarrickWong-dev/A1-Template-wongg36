package ca.mcmaster.se2aa4.mazerunner;

public abstract class Command{//Changes the state of the man!
    protected Marker marker;
    protected Maze maze;

    protected Command(Maze maze, Marker marker){
        this.maze = maze;
        this.marker = marker;
    }
    protected abstract void execute(); //find a path

}
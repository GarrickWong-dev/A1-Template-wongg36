package ca.mcmaster.se2aa4.mazerunner;

public abstract class Command{//Changes the state of the marker
    protected Marker marker;
    protected Maze maze;

    protected Command(Maze maze, Marker marker){
        this.maze = maze;
        this.marker = marker;
    }
    protected abstract void execute(); //Explore a path

}
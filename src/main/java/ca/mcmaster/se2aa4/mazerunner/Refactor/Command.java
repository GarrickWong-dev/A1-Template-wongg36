package ca.mcmaster.se2aa4.mazerunner.Refactor;

public abstract class Command{//Changes the state of the man!
    protected Marker marker;
    protected Maze maze;

    protected void Command(Maze maze){
        this.maze = maze;
        this.marker = new Marker(maze.getStart());
    }
    protected abstract void execute(); //find a path

}
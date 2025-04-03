package ca.mcmaster.se2aa4.mazerunner;
public class CheckPossible{
    protected Marker marker;
    protected Maze maze;

    protected CheckPossible(Maze maze){
        this.maze = maze;
        this.marker = new Marker(maze.getStart());
    }

    //Algorithim that solves the maze by "Keeping hand on right wall" (awlays turns right if possible)
    public boolean checkSolvable(){

        while (!this.marker.getCoords().equals(maze.getEnd())){
            if (this.marker.getCoords().equals(maze.getStart())&&marker.getState()!=0){
                return false;
            }else if (this.marker.checkRight(this.maze)){
                this.marker.turnRight();
                this.marker.stepForward();
            }else if (this.marker.checkFront(this.maze)){
                this.marker.stepForward();
            }else{
                this.marker.turnLeft();
            }
        }
        return true;
    }
}

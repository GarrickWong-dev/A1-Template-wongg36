package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRuleCommand extends Command{

    public RightHandRuleCommand(Maze maze, Marker marker){
        super(maze, marker);
    }

    //Algorithim that solves the maze by "Keeping hand on right wall" (awlays turns right if possible)
    @Override
    public void execute(){
        while (!this.marker.getCoords().equals(maze.getEnd())){
            if (this.marker.checkRight(this.maze)){
                this.marker.turnRight();
                this.marker.stepForward();
            }else if (this.marker.checkFront(this.maze)){
                this.marker.stepForward();
            }else{
                this.marker.turnLeft();
            }
        }
        this.marker.setState(4);
    }
}
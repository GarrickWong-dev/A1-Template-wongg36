package ca.mcmaster.se2aa4.mazerunner;

public class PathCheck extends Command{
    //Checks for vaild maths through the maze
    String path;
    public PathCheck(Maze maze, Marker marker, Path path){
        super(maze,marker);
        this.path = path.unfactorPath();
    }

    @Override
    public void execute(){
        boolean outOfBounds = false;
        for (int i = 0; i < this.path.length(); i++){
            if (this.path.charAt(i) == 'L'){
                this.marker.turnLeft();
            }else if (this.path.charAt(i) == 'R'){
                this.marker.turnRight();
            }else if (this.path.charAt(i) == 'F'){
                if (this.marker.coords.equals(this.maze.end) && this.marker.getDirection() == Directions.RIGHT){
                    outOfBounds = true;
                    break;
                }else if (this.marker.checkFront(this.maze)){
                    this.marker.stepForward();
                }else{
                    break;
                }
            }
        }
        if (this.marker.coords.equals(this.maze.end) && !outOfBounds){
            this.marker.setState(5);
        }
    }
}
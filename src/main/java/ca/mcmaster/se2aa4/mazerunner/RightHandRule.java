package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class RightHandRule extends MakePath{

    public RightHandRule(ArrayList<ArrayList<String>> maze){
        super(maze);
    }

    //Algorithim that solves the maze by "Keeping hand on right wall" (awlays turns right if possible)
    @Override
    public void findPath(ArrayList<ArrayList<String>> maze){
        while (!Arrays.equals(this.coordinates,this.end)){
            if (checkRight(maze)){
                turnRight();
                stepForward();
            }else if (checkFront(maze)){
                stepForward();
            }else{
                turnLeft();
            }
        }
        factorPath();
        System.out.println(this.path);
    }
}




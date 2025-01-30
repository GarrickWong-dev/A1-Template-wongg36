package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class RightHandRule extends MakePath{

    public RightHandRule(ArrayList<ArrayList<String>> maze){
        super(maze);
    }

    @Override
    public void findPath(ArrayList<ArrayList<String>> maze){
        while (!Arrays.equals(this.coordinates,this.end)){
            if (checkRight(maze)){
                turnRight();
                if (checkFront(maze)){
                stepForward();
                }
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




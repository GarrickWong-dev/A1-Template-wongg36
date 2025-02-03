package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckPossible extends Movement{

    public CheckPossible(ArrayList<ArrayList<String>> maze){
        super(maze);
    }

    //uses right hand rule to see if maze is solvable.
    public boolean checkSolvable(ArrayList<ArrayList<String>> maze){
        int startY = this.start[0];
        int startX = this.start[1];

        while (!Arrays.equals(this.coordinates,this.end)){

            if (checkRight(maze)){
                turnRight();
                stepForward();
            }else if (checkFront(maze)){
                stepForward();
            }else{
                turnLeft();
            }

            if (this.coordinates[0] == startY && this.coordinates[1] == startX){
                return false;
            }
        }
        return true;
    }
}

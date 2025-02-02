package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckPath extends Movement{
    private String path;
    public CheckPath(ArrayList<ArrayList<String>> maze, String path){
        super(maze);
        this.path = defactor(path);
    }

    protected String defactor(String userPath){ 
        String defactored = "";
        for (int i = 0; i < userPath.length(); i++){
            if (Character.isDigit(userPath.charAt(i))){
                int count = Character.getNumericValue(userPath.charAt(i));
                i = i + 1;
                for (int j = 0; j < count; j++){
                    defactored = defactored + userPath.substring(i, i+1);
                }
            }else{
                defactored = defactored + userPath.substring(i, i+1);
            }
        }
        return defactored;
    }

    public void check(ArrayList<ArrayList<String>> maze){
        boolean outOfBounds = false;
        for (int i = 0; i < this.path.length(); i ++){
            if (this.path.charAt(i) == 'L'){
                turnLeft();
            }else if (this.path.charAt(i) == 'R'){
                turnRight();
            }else if (this.path.charAt(i) == 'F'){
                if (Arrays.equals(this.coordinates, this.end) && (this.directionInd == 0)){
                    outOfBounds = true;
                    break;
                }
                if (checkFront(maze)){
                    stepForward();
                }else{
                     break;
                }
            }
        }
        if(Arrays.equals(this.coordinates, this.end)&&!outOfBounds){
            System.out.println("Path is Correct!");
        }else{
            System.out.println("Path is Incorrect!");
        }
    }
}

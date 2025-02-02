package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckPath extends Movement{
    private String path;
    public CheckPath(ArrayList<ArrayList<String>> maze, String path){
        super(maze);
        this.path = defactor(path);
    }

    //Unfactors a path. Get rid of numbers and replaces it with repretitive steps 
    private String defactor(String userPath){ 
        String defactored = "";
        for (int i = 0; i < userPath.length(); i++){
            if (Character.isDigit(userPath.charAt(i))){
                if (i == userPath.length()-1){
                    break;
                }
                String num = "";
                while (Character.isDigit(userPath.charAt(i))){
                    num = num + userPath.charAt(i);
                    i++;
                }
                int count = Integer.parseInt(num);
                for (int j = 0; j < count; j++){
                    defactored = defactored + userPath.substring(i, i+1);
                }
            }else{
                defactored = defactored + userPath.substring(i, i+1);
            }
        }
        return defactored;
    }

    

    //Moves throught he maze doing the steps listed in the path. Checks if the path leads to the end coooridnites or if an incorrect solution
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

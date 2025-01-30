package ca.mcmaster.se2aa4.mazerunner;
import java.util.*;

public class Check extends Movement{
    private String path;
    public Check(ArrayList<ArrayList<String>> maze, String path){
        super(maze);
        this.path = defactor(path);
    }

    public String defactor(String userPath){ 
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

    @Override
    public void move(ArrayList<ArrayList<String>> maze){
        boolean correct = false;
        for (int i = 0; i < path.length(); i ++){
            if (path.charAt(i) == 'L'){
                turnLeft();
            }else if (path.charAt(i) == 'R'){
                turnRight();
            }else if (path.charAt(i) == 'F'){
                if (checkFront(maze)){
                    stepForward();
                }else{
                     break;
                }
            }
        }
        if(Arrays.equals(this.coordinates, this.end)){
            System.out.println("Path is Correct!");
        }else{
            System.out.println("Path is Incorrect!");
        }
    }
}
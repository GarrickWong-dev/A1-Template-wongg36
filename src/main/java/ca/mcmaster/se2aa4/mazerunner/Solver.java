package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class Solver{
    private String path = "";
    private ArrayList<ArrayList<String>> maze = new ArrayList<>();
    private int[] coordinates = new int[2];
    private int[] start = new int[2];
    private int[] end = new int[2];
    private String [] directions = {"RIGHT", "DOWN", "LEFT", "UP"}; 
    private int directionInd = 0;
    private String direction = this.directions[this.directionInd];

    //Coordinates currently in YX form (Up down) (Right Left)
    public Solver(ArrayList<ArrayList<String>> maze){
        this.maze = maze;
        this.start[1] = 0;
        this.end[1] = this.maze.get(0).size()-1;
    }

    public void findStart(){
         for (int i = 0; i < this.maze.size(); i++){
             if (this.maze.get(i).get(0).equals("PASS")){
                 this.start[0] = i;
            }
        }
        this.coordinates = this.start;
    }

    public void findEnd(){
         for (int i = 0; i < this.maze.size(); i++){
             if (this.maze.get(i).get(this.maze.get(0).size()-1).equals("PASS")){
                 this.end[0] = i;
             }
         }  
    }


    public boolean checkFront(){
        if (this.direction.equals("RIGHT")){
            if (this.maze.get(this.coordinates[0]).get(this.coordinates[1]+1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("LEFT")){
            if (this.maze.get(this.coordinates[0]).get(this.coordinates[1]-1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("UP")){
            if (this.maze.get(this.coordinates[0]-1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("DOWN")){
            if (this.maze.get(this.coordinates[0]+1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }
        return true;
    }

    public boolean checkRight(){
        if (this.direction.equals("RIGHT")){
            if (this.maze.get(this.coordinates[0]+1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("LEFT")){
            if (this.maze.get(this.coordinates[0]-1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("UP")){
            if (this.maze.get(this.coordinates[0]).get(this.coordinates[1]+1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("DOWN")){
            if (this.maze.get(this.coordinates[0]).get(this.coordinates[1]-1).equals("WALL")){
                return false;
            }
        }
        return true;
    }

    public void stepForward(){
        if (this.direction.equals("RIGHT")){
            this.coordinates[1] = this.coordinates[1]+1;
        }else if (this.direction.equals("LEFT")){
            this.coordinates[1] = this.coordinates[1]-1;
        }else if (this.direction.equals("UP")){
            this.coordinates[0] = this.coordinates[0]-1;
        }else if (this.direction.equals("DOWN")){
            this.coordinates[0] = this.coordinates[0]+1;     
        }
        this.path = this.path+"F";
    }
    //Done so far!

    public void turnRight(){
        this.directionInd = (this.directionInd + 1) % 4;
        this.direction = this.directions[this.directionInd];
        this.path = this.path+"R";
    }
    
    public void turnLeft(){
        this.directionInd = (this.directionInd + 3) % 4;
        this.direction = this.directions[this.directionInd];
        this.path = this.path+"L";
    }

    public void findPath(){
        //Change to better logic
        findStart();
        System.out.println("start found");
        findEnd();
        System.out.println("End found");
        while (!Arrays.equals(this.coordinates,this.end)){
            if (checkRight()){
                turnRight();
                if (checkFront()){
                stepForward();
                }
            }else if (checkFront()){
                stepForward();
            }else{
                turnLeft();
            }
        }
        System.out.println(this.path);
    }

    public void factorPath(){
        int count = 1;
        String factored = "";
        for (int i = 0; i < this.path.length()-1; i++){
            if (this.path.charAt(i) == this.path.charAt(i+1)){
                count = count + 1;
                if (i == this.path.length()-2){
                    if (count > 1){
                    factored = factored + String.valueOf(count);
                }
                factored = factored + this.path.substring(i,i+1);
                }
            }else{
                if (count > 1){
                    factored = factored + String.valueOf(count);
                    count = 1;
                }
                factored = factored + this.path.substring(i,i+1);
            }
        }
        this.path = factored;
    }

    public String defactor(String userPath){ //Take in user inputed path and turn it into the defactored form
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

    public boolean checkPath(String userPath){ //Check to see if after path tranlations, coordiantes is the same as end. Print incorrect path if a step is invalid
        findStart();
        findEnd();
        String path = defactor(userPath);
        for (int i = 0; i < path.length(); i ++){
            if (path.charAt(i) == 'L'){
                turnLeft();
            }else if (path.charAt(i) == 'R'){
                turnRight();
            }else if (path.charAt(i) == 'F'){
                if (checkFront()){
                    stepForward();
                }else{
                    return false;
                }
            }
        }
        if(Arrays.equals(this.coordinates, this.end)){
            return true;
        }else{
            return false;
        }
    }

    public String getPath(){
        return this.path;
    }
}

package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public abstract class Movement{

    protected String path = "";
    protected int[] coordinates = new int[2];
    protected int[] start = new int[2];
    protected int[] end = new int[2];
    protected String [] directions = {"RIGHT", "DOWN", "LEFT", "UP"}; 
    protected int directionInd = 0;
    protected String direction = this.directions[this.directionInd];

    //Coordinates currently in YX form (Up down) (Right Left)
    public Movement(ArrayList<ArrayList<String>> maze){
        this.start[1] = 0;
        this.end[1] = maze.get(0).size()-1;
        findStart(maze);
        findEnd(maze);
    }

    public void findStart(ArrayList<ArrayList<String>> maze){
         for (int i = 0; i < maze.size(); i++){
             if (maze.get(i).get(0).equals("PASS")){
                 this.start[0] = i;
            }
        }
        this.coordinates = this.start;
    }

    public void findEnd(ArrayList<ArrayList<String>> maze){
         for (int i = 0; i < maze.size(); i++){
             if (maze.get(i).get(maze.get(0).size()-1).equals("PASS")){
                 this.end[0] = i;
             }
         }  
    }


    public boolean checkFront(ArrayList<ArrayList<String>> maze){
        if (this.direction.equals("RIGHT")){
            if (maze.get(this.coordinates[0]).get(this.coordinates[1]+1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("LEFT")){
            if (maze.get(this.coordinates[0]).get(this.coordinates[1]-1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("UP")){
            if (maze.get(this.coordinates[0]-1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("DOWN")){
            if (maze.get(this.coordinates[0]+1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }
        return true;
    }

    public boolean checkRight(ArrayList<ArrayList<String>> maze){
        if (this.direction.equals("RIGHT")){
            if (maze.get(this.coordinates[0]+1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("LEFT")){
            if (maze.get(this.coordinates[0]-1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("UP")){
            if (maze.get(this.coordinates[0]).get(this.coordinates[1]+1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("DOWN")){
            if (maze.get(this.coordinates[0]).get(this.coordinates[1]-1).equals("WALL")){
                return false;
            }
        }
        return true;
    }

    public boolean checkLeft(ArrayList<ArrayList<String>> maze){
        if (this.direction.equals("RIGHT")){
            if (maze.get(this.coordinates[0]-1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("LEFT")){
            if (maze.get(this.coordinates[0]+1).get(this.coordinates[1]).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("UP")){
            if (maze.get(this.coordinates[0]).get(this.coordinates[1]-1).equals("WALL")){
                return false;
            }
        }else if (this.direction.equals("DOWN")){
            if (maze.get(this.coordinates[0]).get(this.coordinates[1]+1).equals("WALL")){
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


}

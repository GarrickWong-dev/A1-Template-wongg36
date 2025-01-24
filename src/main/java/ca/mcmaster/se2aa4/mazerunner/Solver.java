package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*;

public class Solver{
    String path = "";
    ArrayList<ArrayList<String>> maze = new ArrayList<>();
    int[] coordinates = new int[2];
    int[] start = new int[2];
    int[] end = new int[2];
    String [] directions = {"RIGHT", "DOWN", "LEFT", "UP"}; 
    int directionInd = 0;
    String direction = this.directions[this.directionInd];

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
    }
    //Done so far!

    public void findPath(){
        //Change to better logic
        findStart();
        findEnd();
        while (!Arrays.equals(this.coordinates,this.end)){
            if (checkFront()){
                stepForward();
                this.path = this.path+"F";
            }else{
                this.directionInd = (this.directionInd + 1) % 4;
                this.direction = this.directions[directionInd];
                this.path = this.path+"R";
            }
        }
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
                }
                factored = factored + this.path.substring(i,i+1);
            }
        }
        this.path = factored;
    }

    public void defactor(String userPath){ //Take in user inputed path and turn it into the defactored form
        for (int i = 0; i < userPath.length(); i++){
            this.path = this.path + userPath.substring(i, i+1);
        }
    }

    public void checkPath(){ //Check to see if after path tranlations, coordiantes is the same as end. Print incorrect path if a step is invalid
        findStart();
        findEnd();
        if (this.path.equals("FFFF")){
            System.out.println("Correct Path");
        }else{
            System.out.println("Incorrect Path");
        }
    }
    public String getPath(){
        return this.path;
    }
}

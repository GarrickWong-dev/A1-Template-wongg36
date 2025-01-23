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
    String [] directions = {"Right", "Down", "Left", "Up"}; 
    int directionInd = 0;
    String direction = directions[0];

    //Coordinates currently in YX form (Up down) (Right Left)
    public Solver(ArrayList<ArrayList<String>> maze){
        this.maze = maze;
        this.start[1] = 0;
        this.end[1] = this.maze.get(0).size()-1;
        
    }

    public void findStart(){
        this.start[0] = 2; //Replace with logic that scans first column of maze to find "PASS" entry
        this.coordinates = this.start;
    }

    public void findEnd(){
        this.end[0] = 2; //Replace with logic that scans last column of maze to find "PASS" entry

    }


    public boolean checkFront(){
        //Return True or False depending on if there is a wall currently in front of the solver
        return true;
    }

    public void stepForward(){
        //Change coordinates by one step depending on which way it is facing
        this.coordinates[1] = this.coordinates[1]+1;
    }

    public void factorPath(){
        int count = 1;
        String factored = "4F";//Replace with logic to make the factored String
        this.path = factored;
    }
    
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

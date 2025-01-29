package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*;

public class Maze{
    private ArrayList<ArrayList<String>> maze = new ArrayList<>();

    public Maze (ArrayList<ArrayList<String>> maze){
        this.maze = maze;
    }
    public ArrayList<ArrayList<String>> getMaze(){
        return this.maze;
    }
    
}

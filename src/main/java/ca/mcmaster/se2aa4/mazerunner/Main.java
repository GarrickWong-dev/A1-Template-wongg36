package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        

        logger.info("** Starting Maze Runner");

        //Initialize Maze Object. Pass Args as parameter for constructor. 
        InputExporter input = new InputExporter();

        Maze maze = new Maze(input.getMaze(args));

        for (ArrayList<String> row : maze.getMaze()) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println(); // Newline after each row
        }
    }
}

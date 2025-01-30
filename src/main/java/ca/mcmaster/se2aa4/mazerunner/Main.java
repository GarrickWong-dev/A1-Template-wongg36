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
        logger.info("Exporting maze");

        InputExporter input = new InputExporter(args);


        Maze maze = new Maze(input.getMaze());

        for (ArrayList<String> row : maze.getMaze()) {
            for (String num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        //input.getPath();
        logger.info("Maze Exported");
        if (true){
            RightHandRule solver = new RightHandRule(maze.getMaze());
            solver.move(maze.getMaze());
        }



    }
}

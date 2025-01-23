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
        Maze maze = new Maze(args);

        logger.info("**** Computing path");
        Solver solver = new Solver(maze.getMaze());
        solver.findEnd();
        solver.coordinates[0] = 2;
        solver.coordinates[1] = 1;
        System.out.println(solver.coordinates[0] + " " + solver.coordinates[1]);
        System.out.println(solver.direction);
        System.out.println(solver.checkFront());
        

        
        // if (maze.getPath() == null){
        //     solver.findPath();
        //     logger.trace(solver.getPath());
        //     logger.info("**** Factoring path");
        //     solver.factorPath();
        //     System.out.println(solver.getPath());
        // }else{
        //     logger.info("**** Making path readable");
        //     solver.defactor(maze.getPath());
        //     logger.info("**** Checking Path");
        //     solver.checkPath();
        // }
        logger.info("** End of MazeRunner");
    }
}

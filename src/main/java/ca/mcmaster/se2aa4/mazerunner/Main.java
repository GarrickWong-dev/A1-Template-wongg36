package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*;

public class Main {
    //creating logger
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws InvalidMazeException{
        

        logger.info("** Starting Maze Runner");

        logger.info("Exporting maze");

        //Grab user input from command line
        InputExporter input = new InputExporter(args);
        InputValidator inputValidator = new InputValidator();

        //Stores Maze and Path gotten from command line
        
        Maze maze = new Maze(input.getMaze());
        String path = input.getPath();
        try{
            inputValidator.validateMaze(maze.getMaze());
            inputValidator.validatePath(path);
            logger.info("Maze Exported");

            //if no -p field, finds solution to maze. If has -p field, check solutiuon to maze
            if (path.equals("No Input")){
                RightHandRule solver = new RightHandRule(maze.getMaze());
                solver.findPath(maze.getMaze());
            }else{
                CheckPath checker = new CheckPath(maze.getMaze(), path);
                checker.check(maze.getMaze());
            }
        }catch (InvalidMazeException e) {
            logger.error(e.getMessage());
        }catch (InvalidPathException e) {
            logger.error(e.getMessage());
        }

        


    }


}

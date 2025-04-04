package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    //creating logger
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws InvalidMazeException{

        

        logger.info("** Starting Maze Runner");

        try{
            logger.info("Exporting maze");
            
            //Grab user input from command line
            InputExporter input = new InputExporter(args);
            InputValidator inputValidator = new InputValidator();
            
            //Stores Maze and Path gotten from command line
            Maze maze = new Maze(input.getMaze());
            inputValidator.validateMaze(maze);
            String inputPath = input.getPath();
            inputValidator.validatePath(inputPath);

            //make marker
            Marker marker = new Marker(maze.getStart());

            logger.info("Maze Exported");
            

            //if no -p field, finds solution to maze. If has -p field, check solutiuon to maze
            if (inputPath.equals("No Input")){
                Path path = new Path(marker);
                RightHandRuleCommand solver = new RightHandRuleCommand(maze, marker);
                solver.execute();
                System.out.println(path.getPath());
            }else{
                Path path = new Path(inputPath);
                PathCheck checker = new PathCheck(maze, marker, path);
                checker.execute();
                if (marker.getState() == 5){
                    System.out.println("Path is Correct!");
                }else{
                    System.out.println("Path is Inorrect!");
                }
            }
        }catch (InvalidMazeException e) {
            System.err.println(e.getMessage());
        }catch (InvalidPathException e) {
             logger.error(e.getMessage());
        }

        


    }


}

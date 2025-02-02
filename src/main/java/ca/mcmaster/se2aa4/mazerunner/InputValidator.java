package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
public class InputValidator {
    public void validateMaze(ArrayList<ArrayList<String>> maze) throws InvalidMazeException{
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(0).size() != maze.get(i).size()){
                throw new InvalidMazeException("Rows in maze must all be the same length");
            }
            for (int j = 0; j < maze.get(i).size(); j++) {
                if (!maze.get(i).get(j).equals("WALL") && !maze.get(i).get(j).equals("PASS")){
                    throw new InvalidMazeException("Maze can only contain characters '#' and ' '");
                } 
            }
        }
    }
    public void validatePath(String path) throws InvalidPathException{
        if (!path.equals("No Input")){
            for (int i = 0; i < path.length(); i++){
                if (path.charAt(i) != 'F' && path.charAt(i) != 'R' && path.charAt(i) != 'L' && !Character.isDigit(path.charAt(i))){
                    throw new InvalidPathException("Path can only contain: digits, 'F', 'L', 'R'");
                }
            }
        }
    }
}
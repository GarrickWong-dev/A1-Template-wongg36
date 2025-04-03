package ca.mcmaster.se2aa4.mazerunner;
public class InputValidator {
    //Checks for user input error for the Maze
    public void validateMaze(Maze maze) throws InvalidMazeException{
        CheckPossible checker = new CheckPossible(maze);
        for (int i = 0; i < maze.getMaze().size(); i++) {
            if (maze.getMaze().get(0).size() != maze.getMaze().get(i).size()){
                throw new InvalidMazeException("Rows in maze must all be the same length");
            }
            for (int j = 0; j < maze.getMaze().get(i).size(); j++) {
                if (!maze.getMaze().get(i).get(j).equals(Spot.PASS) && !maze.getMaze().get(i).get(j).equals(Spot.WALL)){
                    throw new InvalidMazeException("Maze can only contain characters '#' and ' '");
                } 
            }
        }
        if (!checker.checkSolvable()){
            throw new InvalidMazeException("Maze is not solvable");
        }
    }

    //Checks for user input error for the path
    // public void validatePath(String path) throws InvalidPathException{
    //     if (!path.equals("No Input")){
    //         for (int i = 0; i < path.length(); i++){
    //             if (path.charAt(i) != 'F' && path.charAt(i) != 'R' && path.charAt(i) != 'L' && !Character.isDigit(path.charAt(i))){
    //                 throw new InvalidPathException("Path can only contain: digits, 'F', 'L', 'R'");
    //             }
    //         }
    //     }
    // }
}
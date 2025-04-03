package ca.mcmaster.se2aa4.mazerunner.Refactor;

public class Actions{
    public Coordinates moveForward(Coordinates coords, Directions direction) {
        switch (direction) {
            case RIGHT -> coords.setX(coords.getX()+1);
            case DOWN -> coords.setY(coords.getY()+1);
            case LEFT -> coords.setX(coords.getX()-1);
            case UP -> coords.setY(coords.getY()-1);
            default -> {
            }
        }
        return coords;
    }

    public Directions turnLeft(Directions direction) {
        switch (direction) {
            case RIGHT -> direction = Directions.UP;
            case DOWN -> direction = Directions.RIGHT;
            case LEFT -> direction = Directions.DOWN;
            case UP -> direction = Directions.LEFT;
            default -> {
            }
        }
        return direction;
    }

    public Directions turnRight(Directions direction) {
        switch (direction) {
            case RIGHT -> direction = Directions.DOWN;
            case DOWN -> direction = Directions.LEFT;
            case LEFT -> direction = Directions.UP;
            case UP -> direction = Directions.RIGHT;
            default -> {
            }
        }
        return direction;
    }

    public boolean checkFront(Maze maze, Coordinates coords, Directions direction) {
        switch (direction) {
            case RIGHT -> {
                if (maze.getSpot(coords.getX()+1, coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case DOWN -> {
                if (maze.getSpot(coords.getX(), coords.getY()+1) == Spot.PASS){
                    return true;
                }
            }
            case LEFT -> {
                if (maze.getSpot(coords.getX()-1, coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case UP -> {
                if (maze.getSpot(coords.getX(), coords.getY()-1) == Spot.PASS){
                    return true;
                }
            }
            default -> {
            }
        }
        return false;
    }

        public boolean checkRight(Maze maze, Coordinates coords, Directions direction) {
        switch (direction) {
            case RIGHT -> {
                if (maze.getSpot(coords.getX(), coords.getY()+1) == Spot.PASS){
                    return true;
                }
            }
            case DOWN -> {
                if (maze.getSpot(coords.getX()-1, coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case LEFT -> {
                if (maze.getSpot(coords.getX(), coords.getY()-1) == Spot.PASS){
                    return true;
                }
            }
            case UP -> {
                if (maze.getSpot(coords.getX()+1, coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            default -> {
            }
        }
        return false;
    }

        public boolean checkLeft(Maze maze, Coordinates coords, Directions direction) {
        switch (direction) {
            case RIGHT -> {
                if (maze.getSpot(coords.getX(), coords.getY()-1) == Spot.PASS){
                    return true;
                }
            }
            case DOWN -> {
                if (maze.getSpot(coords.getX()+1, coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case LEFT -> {
                if (maze.getSpot(coords.getX(), coords.getY()+1) == Spot.PASS){
                    return true;
                }
            }
            case UP -> {
                if (maze.getSpot(coords.getX()-1, coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            default -> {
            }
        }
        return false;
    }
}
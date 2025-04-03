package ca.mcmaster.se2aa4.mazerunner;

public class Marker extends Subject {

    Coordinates coords = new Coordinates();
    Directions direction = Directions.RIGHT;

    public Marker(Coordinates coords){
        this.coords.setX(coords.getX());
        this.coords.setY(coords.getY());
        setState(0);
    } 


    public Coordinates getCoords(){
        return this.coords;
    }

    public void setDirection(Directions direction){
        this.direction = direction;
    }

    public void stepForward() {
        switch (this.direction) {
            case RIGHT -> this.coords.setX(coords.getX()+1);
            case DOWN -> this.coords.setY(coords.getY()+1);
            case LEFT -> this.coords.setX(coords.getX()-1);
            case UP -> this.coords.setY(coords.getY()-1);
        }
        setState(1);
    }

    public void turnLeft() {
        switch (this.direction) {
            case RIGHT -> setDirection(Directions.UP);
            case DOWN -> setDirection(Directions.RIGHT);
            case LEFT -> setDirection(Directions.DOWN);
            case UP -> setDirection(Directions.LEFT);
        }
        setState(2);
    }

    public void turnRight() {
        switch (this.direction) {
            case RIGHT -> setDirection(Directions.DOWN);
            case DOWN -> setDirection(Directions.LEFT);
            case LEFT -> setDirection(Directions.UP);
            case UP -> setDirection(Directions.RIGHT);
        }
        setState(3);
    }

    public boolean checkFront(Maze maze) {
        switch (this.direction) {
            case RIGHT -> {
                if (maze.getSpot(this.coords.getX()+1, this.coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case DOWN -> {
                if (maze.getSpot(this.coords.getX(), this.coords.getY()+1) == Spot.PASS){
                    return true;
                }
            }
            case LEFT -> {
                if (maze.getSpot(this.coords.getX()-1, this.coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case UP -> {
                if (maze.getSpot(this.coords.getX(), this.coords.getY()-1) == Spot.PASS){
                    return true;
                }
            }
        }
        return false;
    }

        public boolean checkRight(Maze maze) {
        switch (this.direction) {
            case RIGHT -> {
                if (maze.getSpot(this.coords.getX(), this.coords.getY()+1) == Spot.PASS){
                    return true;
                }
            }
            case DOWN -> {
                if (maze.getSpot(this.coords.getX()-1, this.coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case LEFT -> {
                if (maze.getSpot(this.coords.getX(), this.coords.getY()-1) == Spot.PASS){
                    return true;
                }
            }
            case UP -> {
                if (maze.getSpot(this.coords.getX()+1, this.coords.getY()) == Spot.PASS){
                    return true;
                }
            }
        }
        return false;
    }

        public boolean checkLeft(Maze maze) {
        switch (direction) {
            case RIGHT -> {
                if (maze.getSpot(this.coords.getX(), this.coords.getY()-1) == Spot.PASS){
                    return true;
                }
            }
            case DOWN -> {
                if (maze.getSpot(this.coords.getX()+1, this.coords.getY()) == Spot.PASS){
                    return true;
                }
            }
            case LEFT -> {
                if (maze.getSpot(this.coords.getX(), this.coords.getY()+1) == Spot.PASS){
                    return true;
                }
            }
            case UP -> {
                if (maze.getSpot(this.coords.getX()-1, this.coords.getY()) == Spot.PASS){
                    return true;
                }
            }
        }
        return false;
    }
}
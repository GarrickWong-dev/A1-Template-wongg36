package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckLeftTest{
    private ArrayList<ArrayList<Spot>> maze;
    Coordinates coords = new Coordinates();
    Marker marker;
    private Maze mazeCheck;
    
    @BeforeEach
    public void initialize(){
        this.maze = new ArrayList<>();
        ArrayList<Spot> row1 = new ArrayList<>();
        row1.add(Spot.WALL);
        row1.add(Spot.WALL);
        row1.add(Spot.WALL);
        this.maze.add(row1);
        ArrayList<Spot> row2 = new ArrayList<>();
        row2.add(Spot.WALL);
        row2.add(Spot.PASS);
        row2.add(Spot.WALL);
        this.maze.add(row2);
        ArrayList<Spot> row3 = new ArrayList<>();
        row3.add(Spot.WALL);
        row3.add(Spot.WALL);
        row3.add(Spot.WALL);
        this.maze.add(row3);

        this.mazeCheck = new Maze(this.maze);
        this.coords.setX(1);
        this.coords.setY(1);
        this.marker = new Marker(coords);
    }
    @Test
    public void testUp(){
        this.marker.setDirection(Directions.UP);
        assertEquals(false,this.marker.checkLeft(this.mazeCheck));
        this.maze.get(1).set(0,Spot.PASS);
        this.mazeCheck = new Maze(this.maze);
        assertEquals(true,this.marker.checkLeft(this.mazeCheck));
    }

    @Test
    public void testRight(){
        this.marker.setDirection(Directions.RIGHT);
        assertEquals(false,this.marker.checkLeft(this.mazeCheck));
        this.maze.get(0).set(1,Spot.PASS);
        this.mazeCheck = new Maze(this.maze);
        assertEquals(true,this.marker.checkLeft(this.mazeCheck));

    }

    @Test
    public void testDown(){
        this.marker.setDirection(Directions.DOWN);
        assertEquals(false,this.marker.checkLeft(this.mazeCheck));
        this.maze.get(1).set(2,Spot.PASS);
        this.mazeCheck = new Maze(this.maze);
        assertEquals(true,this.marker.checkLeft(this.mazeCheck));

    }

    @Test
    public void testLeft(){
        this.marker.setDirection(Directions.LEFT);
        assertEquals(false,this.marker.checkLeft(this.mazeCheck));
        this.maze.get(2).set(1,Spot.PASS);
        this.mazeCheck = new Maze(this.maze);
        assertEquals(true,this.marker.checkLeft(this.mazeCheck));
    }
}
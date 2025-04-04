package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class mazeTest{
    private ArrayList<ArrayList<Spot>> maze;

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
        row2.add(Spot.WALL);
        row2.add(Spot.WALL);
        this.maze.add(row2);
        ArrayList<Spot> row3 = new ArrayList<>();
        row3.add(Spot.WALL);
        row3.add(Spot.WALL);
        row3.add(Spot.WALL);
        this.maze.add(row3);
    }

    @Test
    public void testStart(){
        this.maze.get(1).set(0,Spot.PASS);
        Maze maze = new Maze(this.maze);
        Coordinates coords = new Coordinates();
        coords.setX(0);
        coords.setY(1); 
        assertEquals(true, coords.equals(maze.getStart()));
    }

        @Test
    public void testEnd(){
        this.maze.get(1).set(2,Spot.PASS);
        Maze maze = new Maze(this.maze);
        Coordinates coords = new Coordinates();
        coords.setX(2);
        coords.setY(1); 
        assertEquals(true, coords.equals(maze.getEnd()));
    }
}
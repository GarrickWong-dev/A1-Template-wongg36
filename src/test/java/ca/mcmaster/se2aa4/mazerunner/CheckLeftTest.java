package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckLeftTest{
    private ArrayList<ArrayList<String>> maze;
    private TestMovement move;

    @BeforeEach
    public void initialize(){
        this.maze = new ArrayList<>();
        ArrayList<String> row1 = new ArrayList<>();
        row1.add("WALL");
        row1.add("WALL");
        row1.add("WALL");
        this.maze.add(row1);
        ArrayList<String> row2 = new ArrayList<>();
        row2.add("WALL");
        row2.add("PASS");
        row2.add("WALL");
        this.maze.add(row2);
        ArrayList<String> row3 = new ArrayList<>();
        row3.add("WALL");
        row3.add("WALL");
        row3.add("WALL");
        this.maze.add(row3);
        this.move = new TestMovement(this.maze);
        this.move.setStart();
    } 
    @Test
    public void testUp(){
        this.move.setDirection("UP");
        assertEquals(false,this.move.checkLeft(this.maze));
        this.maze.get(1).set(0,"PASS");
        assertEquals(true,this.move.checkLeft(this.maze));
    }

    @Test
    public void testRight(){
        this.move.setDirection("RIGHT");
        assertEquals(false,this.move.checkLeft(this.maze));
        this.maze.get(0).set(1,"PASS");
        assertEquals(true,this.move.checkLeft(this.maze));

    }

    @Test
    public void testDown(){
        this.move.setDirection("DOWN");
        assertEquals(false,this.move.checkLeft(this.maze));
        this.maze.get(1).set(2,"PASS");
        assertEquals(true,this.move.checkLeft(this.maze));

    }

    @Test
    public void testLeft(){
        this.move.setDirection("LEFT");
        assertEquals(false,this.move.checkLeft(this.maze));
        this.maze.get(2).set(1,"PASS");
        assertEquals(true,this.move.checkLeft(this.maze));
    }
}
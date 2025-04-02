package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForwardTest{//change to test this.movement
    private ArrayList<ArrayList<String>> maze;
    private TestMovement move;
    
    @BeforeEach
    public void initialize(){
        this.maze = new ArrayList<>();
        ArrayList<String> row1 = new ArrayList<>();
        row1.add("WALL");
        row1.add("PASS");
        row1.add("WALL");
        this.maze.add(row1);
        ArrayList<String> row2 = new ArrayList<>();
        row2.add("PASS");
        row2.add("PASS");
        row2.add("PASS");
        this.maze.add(row2);
        ArrayList<String> row3 = new ArrayList<>();
        row3.add("WALL");
        row3.add("PASS");
        row3.add("WALL");
        this.maze.add(row3);
        this.move = new TestMovement(this.maze);
        this.move.setStart();
    }

    @Test
    public void testMoveUp(){
        this.move.setDirection("UP");
        this.move.stepForward();
        assertEquals(0,this.move.getY());
        assertEquals(1,this.move.getX());
    }

    @Test
    public void testMoveRight(){
        this.move.setDirection("RIGHT");
        this.move.stepForward();
        assertEquals(1,this.move.getY());
        assertEquals(2,this.move.getX());
    }

    @Test
    public void testMoveDOWN(){
        this.move.setDirection("DOWN");
        this.move.stepForward();
        assertEquals(2,this.move.getY());
        assertEquals(1,this.move.getX());
    }

    @Test
    public void testMoveLeft(){
        this.move.setDirection("LEFT");
        this.move.stepForward();
        assertEquals(1,this.move.getY());
        assertEquals(0,this.move.getX());
    }

}

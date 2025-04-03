package ca.mcmaster.se2aa4.mazerunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForwardTest{//change to test this.movement
    private Coordinates coords = new Coordinates();
    private Marker marker;
    
    @BeforeEach
    public void initialize(){
        this.coords.setX(1);
        this.coords.setY(1);
        this.marker = new Marker(coords);
    }

    @Test
    public void testMoveUp(){
        this.marker.setDirection(Directions.UP);
        this.marker.stepForward();
        assertEquals(0,this.marker.coords.getY());
        assertEquals(1,this.marker.coords.getX());
    }

    @Test
    public void testMoveRight(){
        this.marker.setDirection(Directions.RIGHT);
        this.marker.stepForward();
        assertEquals(1,this.marker.coords.getY());
        assertEquals(2,this.marker.coords.getX());
    }

    @Test
    public void testMoveDOWN(){
        this.marker.setDirection(Directions.DOWN);
        this.marker.stepForward();
        assertEquals(2,this.marker.coords.getY());
        assertEquals(1,this.marker.coords.getX());
    }

    @Test
    public void testMoveLeft(){
        this.marker.setDirection(Directions.LEFT);
        this.marker.stepForward();
        assertEquals(1,this.marker.coords.getY());
        assertEquals(0,this.marker.coords.getX());
    }

}

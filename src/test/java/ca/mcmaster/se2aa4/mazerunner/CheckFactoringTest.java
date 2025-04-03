package ca.mcmaster.se2aa4.mazerunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckFactoringTest{
    private Marker marker;
    private Path path;
    private Coordinates coords = new Coordinates();

    @BeforeEach
    public void initialize(){
        Coordinates coords = new Coordinates();
        this.marker = new Marker(coords);
        this.path = new Path(this.marker);
    }

    @Test
    public void Test1F(){
        this.marker.stepForward();
        assertEquals("F",this.path.getPath());
    }

    @Test
    public void Test1L(){
        this.marker.turnLeft();
        assertEquals("L",this.path.getPath());
    }

    @Test
    public void Test1R(){
        this.marker.turnRight();
        assertEquals("R",this.path.getPath());
    }

    @Test
    public void TestDuplicates(){
        this.marker.stepForward();
        this.marker.stepForward();
        this.marker.stepForward();
        this.marker.turnLeft();
        this.marker.turnLeft();
        this.marker.turnLeft();
        this.marker.turnRight();
        this.marker.turnRight();
        this.marker.turnRight();
        this.path.factorPath();
        assertEquals("3F3L3R",this.path.factorPath());
    }

    @Test
    public void TestDuplicatesEndCase(){
        this.marker.stepForward();
        this.marker.stepForward();
        this.marker.stepForward();
        this.marker.turnLeft();
        this.marker.turnLeft();
        this.marker.turnLeft();
        this.marker.turnRight();
        this.marker.turnRight();
        this.marker.turnRight();
        this.marker.stepForward();
        assertEquals("3F3L3RF",this.path.factorPath());
    }

    @Test
    public void TestDuplicatesEndCase2(){
        this.marker.stepForward();
        this.marker.turnLeft();
        this.marker.turnLeft();
        this.marker.turnLeft();
        this.marker.turnRight();
        this.marker.turnRight();
        this.marker.turnRight();
        this.marker.turnLeft();
        this.marker.stepForward();
        this.path.factorPath();
        assertEquals("F3L3RLF",this.path.factorPath());
    }

}


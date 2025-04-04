package ca.mcmaster.se2aa4.mazerunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UnfactorTest{

    @Test
    public void check1(){
        String str = "FLR";
        Path path = new Path(str);
        assertEquals("FLR",path.unfactorPath());
    }

    @Test
    public void check2(){
        String str = "2F2L2R";
        Path path = new Path(str);
        assertEquals("FFLLRR",path.unfactorPath());
    }

    @Test
    public void checkSingleEnd(){
        String str = "R2F3L2RF";
        Path path = new Path(str);
        assertEquals("RFFLLLRRF",path.unfactorPath());
    }

}

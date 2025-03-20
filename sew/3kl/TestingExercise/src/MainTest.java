import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void addieren(){
        int res = Main.addieren(39532,235899);
        int expec =275431;
        assertEquals(expec,res);
    }
    @Test
    void multPos(){
        int res = Main.mult(39,235);
        int expec = 9165;
        assertEquals(expec,res);
    }
    @Test
    void multNeg(){
        int res = Main.mult(-39,-235);
        int expec = 9165;
        assertEquals(expec,res);
    }
}
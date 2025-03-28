import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testFactorialBasicCases() {
        assertEquals(1, Main.ue1Factorial(1));
        assertEquals(2, Main.ue1Factorial(2));
        assertEquals(6, Main.ue1Factorial(3));
        assertEquals(24, Main.ue1Factorial(4));
    }

    @Test
    void testFactorialLargeNumber() {
        assertEquals(3628800, Main.ue1Factorial(10));
    }

    @Test
    void testFactorialEdgeCases() {
        assertEquals(1, Main.ue1Factorial(0));
        assertEquals(479001600, Main.ue1Factorial(12));
    }

    @Test
    void testBunnyEarsBasicCases() {
        assertEquals(0, Main.ue2BunnyEars(0));
        assertEquals(2, Main.ue2BunnyEars(1));
        assertEquals(4, Main.ue2BunnyEars(2));
        assertEquals(6, Main.ue2BunnyEars(3));
    }

    @Test
    void testBunnyEarsLargeNumbers() {
        assertEquals(20, Main.ue2BunnyEars(10));
        assertEquals(40, Main.ue2BunnyEars(20));
    }

    @Test
    void testBunnyEarsEdgeCases() {
        assertEquals(100, Main.ue2BunnyEars(50));
        assertEquals(200, Main.ue2BunnyEars(100));
    }

    @Test
    void testFibonacciBasicSequence() {
        assertEquals(0, Main.ue3Fibonacci(0));
        assertEquals(1, Main.ue3Fibonacci(1));
        assertEquals(1, Main.ue3Fibonacci(2));
        assertEquals(2, Main.ue3Fibonacci(3));
        assertEquals(3, Main.ue3Fibonacci(4));
        assertEquals(5, Main.ue3Fibonacci(5));
        assertEquals(8, Main.ue3Fibonacci(6));
    }

    @Test
    void testFibonacciLargerNumbers() {
        assertEquals(34, Main.ue3Fibonacci(9));
        assertEquals(55, Main.ue3Fibonacci(10));
    }

    @Test
    void testFibonacciHighNumbers() {
        assertEquals(89, Main.ue3Fibonacci(11));
        assertEquals(144, Main.ue3Fibonacci(12));
    }

    @Test
    void testBunnyEars2BasicCases() {
        assertEquals(0, Main.ue4BunnyEars2(0));
        assertEquals(2, Main.ue4BunnyEars2(1));
        assertEquals(5, Main.ue4BunnyEars2(2));
        assertEquals(7, Main.ue4BunnyEars2(3));
        assertEquals(10, Main.ue4BunnyEars2(4));
    }

    @Test
    void testBunnyEars2LargeSequence() {
        assertEquals(25, Main.ue4BunnyEars2(10));
    }

    @Test
    void testBunnyEars2Pattern() {
        assertEquals(12, Main.ue4BunnyEars2(5));
        assertEquals(15, Main.ue4BunnyEars2(6));
        assertEquals(50, Main.ue4BunnyEars2(20));
    }

    @Test
    void testTriangleBasicCases() {
        assertEquals(0, Main.ue5Triangle(0));
        assertEquals(1, Main.ue5Triangle(1));
        assertEquals(3, Main.ue5Triangle(2));
        assertEquals(6, Main.ue5Triangle(3));
        assertEquals(10, Main.ue5Triangle(4));
    }

    @Test
    void testTriangleLargeNumber() {
        assertEquals(55, Main.ue5Triangle(10));
    }

    @Test
    void testTriangleSequence() {
        assertEquals(15, Main.ue5Triangle(5));
        assertEquals(21, Main.ue5Triangle(6));
        assertEquals(136, Main.ue5Triangle(16));
    }

    @Test
    void testSumDigitsBasicCases() {
        assertEquals(9, Main.ue6SumDigits(126));
        assertEquals(13, Main.ue6SumDigits(49));
        assertEquals(3, Main.ue6SumDigits(12));
        assertEquals(1, Main.ue6SumDigits(1));
    }

    @Test
    void testSumDigitsSpecialCases() {
        assertEquals(0, Main.ue6SumDigits(0));
        assertEquals(54, Main.ue6SumDigits(999999));
    }

    @Test
    void testSumDigitsLargeNumbers() {
        assertEquals(46, Main.ue6SumDigits(991999));
        assertEquals(1, Main.ue6SumDigits(100000));
        assertEquals(10, Main.ue6SumDigits(1234));
    }

    @Test
    void testCount7BasicCases() {
        assertEquals(2, Main.ue7Count7(717));
        assertEquals(1, Main.ue7Count7(7));
        assertEquals(0, Main.ue7Count7(123));
        assertEquals(3, Main.ue7Count7(777));
    }

    @Test
    void testCount7SpecialCases() {
        assertEquals(5, Main.ue7Count7(77777));
        assertEquals(0, Main.ue7Count7(0));
        assertEquals(1, Main.ue7Count7(70));
    }

    @Test
    void testCount7ComplexPatterns() {
        assertEquals(3, Main.ue7Count7(7077));
        assertEquals(6, Main.ue7Count7(777777));
        assertEquals(3, Main.ue7Count7(1727374));
    }

    @Test
    void testCount8BasicCases() {
        assertEquals(1, Main.ue8Count8(8));
        assertEquals(2, Main.ue8Count8(818));
        assertEquals(4, Main.ue8Count8(8818));
        assertEquals(5, Main.ue8Count8(888));
    }

    @Test
    void testCount8ConsecutiveEights() {
        assertEquals(5, Main.ue8Count8(888));
        assertEquals(7, Main.ue8Count8(8888));
        assertEquals(0, Main.ue8Count8(123));
    }

    @Test
    void testCount8ComplexPatterns() {
        assertEquals(9, Main.ue8Count8(88888));
        assertEquals(2, Main.ue8Count8(8084));
        assertEquals(4, Main.ue8Count8(88180));
    }

    @Test
    void testPowerNBasicCases() {
        assertEquals(3, Main.ue9PowerN(3, 1));
        assertEquals(9, Main.ue9PowerN(3, 2));
        assertEquals(27, Main.ue9PowerN(3, 3));
    }

    @Test
    void testPowerNLargerExponents() {
        assertEquals(16, Main.ue9PowerN(2, 4));
        assertEquals(32, Main.ue9PowerN(2, 5));
        assertEquals(100, Main.ue9PowerN(10, 2));
    }

    @Test
    void testPowerNComplexCases() {
        assertEquals(1024, Main.ue9PowerN(2, 10));
        assertEquals(125, Main.ue9PowerN(5, 3));
        assertEquals(10000, Main.ue9PowerN(10, 4));
    }

    @Test
    void testArray220BasicCases() {
        assertTrue(Main.ue10Array220(new int[] { 1, 2, 20 }, 0));
        assertTrue(Main.ue10Array220(new int[] { 3, 30 }, 0));
        assertFalse(Main.ue10Array220(new int[] { 3 }, 0));
        assertFalse(Main.ue10Array220(new int[] { 1, 2, 3 }, 0));
    }

    @Test
    void testArray220ComplexCases() {
        assertTrue(Main.ue10Array220(new int[] { 1, 2, 20, 3, 30 }, 0));
        assertFalse(Main.ue10Array220(new int[] { 20, 2, 21 }, 0));
        assertFalse(Main.ue10Array220(new int[] {}, 0));
        assertTrue(Main.ue10Array220(new int[] { 3, 30, 1, 10 }, 0));
    }

    @Test
    void testArray220EdgeCases() {
        assertTrue(Main.ue10Array220(new int[] { 10, 100, 1000 }, 0));
        assertFalse(Main.ue10Array220(new int[] { 10, 50, 20 }, 0));
        assertTrue(Main.ue10Array220(new int[] { 1, 10, 100, 1000 }, 0));
    }

}

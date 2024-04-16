import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Main.calculateFactorial(0));
        assertEquals(1, Main.calculateFactorial(1));
        assertEquals(2, Main.calculateFactorial(2));
        assertEquals(6, Main.calculateFactorial(3));
        assertEquals(24, Main.calculateFactorial(4));
        assertEquals(120, Main.calculateFactorial(5));
    }
}
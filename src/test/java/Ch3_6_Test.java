import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_6_Test {
    @Test
    public void testSquareSequence() {
        var sequence = new Ch3_6.SquareSequence();
        for (var i = 1; i <= 100; i++) {
            assertTrue(sequence.hasNext());
            assertEquals(Integer.toString(i * i), sequence.next().toString());
        }
        assertTrue(sequence.hasNext());
    }
}

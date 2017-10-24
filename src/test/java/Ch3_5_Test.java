import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ch3_5_Test {
    @Test
    public void testConstantIntStream() {
        final int value = 1;
        Ch3_5.IntSequence seq = Ch3_5.IntSequence.constant(value);
        for (int i = 0; i < 20; i++) {
            assertTrue(seq.hasNext());
            assertEquals(value, seq.next());
        }
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_16_Test {
    @Test
    public void testRandomSequence() {
        Ch3_16.IntSequence seq = Ch3_16.randomInts(1, 20);
        for (int i = 0; i < 1000; i++) {
            assertTrue(seq.hasNext());
            int val = seq.next();
            assertTrue(val >= 1 && val <= 20);
        }
    }
}

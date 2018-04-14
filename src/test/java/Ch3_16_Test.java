import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_16_Test {
    @Test
    public void testRandomSequence() {
        var seq = Ch3_16.randomInts(1, 20);
        for (var i = 0; i < 1000; i++) {
            assertTrue(seq.hasNext());
            var val = seq.next();
            assertTrue(val >= 1 && val <= 20);
        }
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_5_Test {
    @Test
    public void testConstantIntStream() {
        final var value = 1;
        var seq = Ch3_5.IntSequence.constant(value);
        for (var i = 0; i < 20; i++) {
            assertTrue(seq.hasNext());
            assertEquals(value, seq.next());
        }
    }
}

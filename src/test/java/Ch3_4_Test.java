import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_4_Test {
    @Test
    public void testIntStream() {
        var data = new int[]{9, 8, 7, 5, 5, 1, 3, 5};
        var seq = Ch3_4.IntSequence.of(data);
        for (var val : data) {
            assertTrue(seq.hasNext());
            assertEquals(val, seq.next());
        }
        assertFalse(seq.hasNext());
    }

    @Test
    public void testExceedIntStream() {
        var seq = Ch3_4.IntSequence.of();
        assertFalse(seq.hasNext());
        assertEquals(0, seq.next());
        assertEquals(0, seq.next()); // verifying that it happens multiple times
    }
}

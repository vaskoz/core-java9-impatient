import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Ch2_16_Test {
    @Test
    public void testQueue() {
        var q = new Ch2_16.Queue();
        q.add("a");
        q.add("b");
        q.add("c");
        q.add("hi");
        assertEquals("a", q.remove());
        assertEquals("b", q.remove());
        assertEquals("c", q.remove());
        q.add("bye");
        q.add("there");
        assertEquals("hi", q.remove());
        assertEquals("bye", q.remove());
        assertEquals("there", q.remove());
        assertNull(q.remove());
    }
}

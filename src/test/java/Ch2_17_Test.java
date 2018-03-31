import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch2_17_Test {
    @Test
    public void testQueueIterator() {
        var q = new Ch2_17.Queue();
        q.add("a");
        q.add("b");
        q.add("c");
        q.add("hi");
        q.add("bye");
        q.add("there");
        var iter = q.iterator();
        assertTrue(iter.hasNext());
        assertEquals("a", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("b", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("c", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("hi", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("bye", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("there", iter.next());
        assertFalse(iter.hasNext());

        assertEquals("a", q.remove());
        assertEquals("b", q.remove());
        assertEquals("c", q.remove());
        assertEquals("hi", q.remove());
        assertEquals("bye", q.remove());
        assertEquals("there", q.remove());
        assertNull(q.remove());
    }
}

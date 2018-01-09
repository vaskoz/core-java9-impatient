import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch7_15_Test {
    @Test
    public void testImmutableListIntFunction() {
        Iterator<Integer> integerIterator = Ch7_15.immutableListView(i -> i + 1);
        for (int i = 1; i <= 100; i++) {
            assertTrue(integerIterator.hasNext());
            assertEquals(i, (int) integerIterator.next());
        }
        assertTrue(integerIterator.hasNext());

        integerIterator = Ch7_15.immutableListView(i -> i + 2);
        for (int i = 1; i <= 100; i++) {
            assertTrue(integerIterator.hasNext());
            assertEquals(i * 2, (int) integerIterator.next());
        }
        assertTrue(integerIterator.hasNext());

        integerIterator = Ch7_15.immutableListView(i -> i + 10);
        for (int i = 1; i <= 100; i++) {
            assertTrue(integerIterator.hasNext());
            assertEquals(i * 10, (int) integerIterator.next());
        }
        assertTrue(integerIterator.hasNext());
    }
}

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Ch7_14_Test {
    @Test
    public void testImmutableListView() {
        var n = 100;
        var integerIterator = Ch7_14.immutableListView(n);
        for (var i = 0; i <= n; i++) {
            assertTrue(integerIterator.hasNext());
            assertEquals(i, (int) integerIterator.next());
        }
        assertFalse(integerIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> integerIterator.next());
    }
}

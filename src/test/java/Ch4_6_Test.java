import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch4_6_Test {
    @Test
    public void testItemSymmetry() {
        var item = new Ch4_6.Item("abc", 10.0);
        var item2 = new Ch4_6.Item("abc", 10.0);
        var item3 = new Ch4_6.Item("abc", 10.1);
        assertTrue(item.equals(item2));
        assertTrue(item2.equals(item));
        assertFalse(item.equals(item3));
        assertFalse(item3.equals(item));
        item.hashCode(); // for good measure, always override hashCode when you override equals
    }

    @Test
    public void testDiscountedItemSymmetry() {
        var item = new Ch4_6.DiscountedItem("abc", 10.0, 2.0);
        var item2 = new Ch4_6.Item("abc", 10.0);
        var item3 = new Ch4_6.DiscountedItem("abc", 10.0, 3.0);
        assertTrue(item.equals(item2));
        assertTrue(item2.equals(item3));
        assertFalse(item.equals(item3)); // breaks symmetry
        item.hashCode(); // for good measure, always override hashCode when you override equals
    }
}

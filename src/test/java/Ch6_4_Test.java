import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Ch6_4_Test {
    @Test
    public void testTable() {
        Ch6_4 app = new Ch6_4();
        Ch6_4.Table<String, Integer> table = app.new Table<>();
        table.set("foo", 1);
        table.set("bar", 2);
        table.set("baz", 3);
        assertEquals(3, (int) table.get("baz"));
        table.set("baz", 4);
        assertEquals(4, (int) table.get("baz"));
        table.remove("baz");
        assertNull(table.get("baz"));
        assertEquals(2, (int) table.get("bar"));
        table.remove("bar");
        assertNull(table.get("bar"));
        assertEquals(1, (int) table.get("foo"));
        table.remove("foo");
        assertNull(table.get("foo"));
        assertNull(table.get("bar"));
        assertNull(table.get("baz"));
        table.remove("doesn't exist");
    }
}

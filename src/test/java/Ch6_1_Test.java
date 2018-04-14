import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch6_1_Test {

    @Test
    public void testBadStackSize() {
        var app = new Ch6_1();
        assertThrows(IllegalArgumentException.class, () -> {
            Ch6_1.Stack<String> stringStack = app.new Stack<>(-1);
        });
    }

    @Test
    public void testPopEmptyStack() {
        var app = new Ch6_1();
        var stringStack = app.new Stack<String>(1);
        assertThrows(IllegalStateException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    public void testPushPopStack() {
        var app = new Ch6_1();
        var stringStack = app.new Stack<String>(1);
        stringStack.push("foo");
        assertFalse(stringStack.isEmpty());
        String result = stringStack.pop();
        assertEquals("foo", result);
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testStack() {
        var app = new Ch6_1();
        var stringStack = app.new Stack<String>(5);
        var data = new String[]{"abc", "def", "ghi"};
        for (var s : data) {
            stringStack.push(s);
        }
        assertFalse(stringStack.isEmpty());
        for (var i = 2; i >= 0; i--) {
            assertEquals(data[i], stringStack.pop());
        }
        assertTrue(stringStack.isEmpty());
    }
}

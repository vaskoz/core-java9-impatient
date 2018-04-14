import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch6_2_Test {

    @Test
    public void testBadStackEASize() {
        var app = new Ch6_2();
        assertThrows(IllegalArgumentException.class, () -> {
            app.new StackEA<String>(0);
        });
    }

    @Test
    public void testBadStackOASize() {
        var app = new Ch6_2();
        assertThrows(IllegalArgumentException.class, () -> {
            app.new StackOA<>(0);
        });
    }

    @Test
    public void testPopEmptyStackEA() {
        var app = new Ch6_2();
        var stringStack = app.new StackEA<String>(1);
        assertTrue(stringStack.isEmpty());
        assertThrows(IllegalStateException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    public void testPopEmptyStackOA() {
        var app = new Ch6_2();
        var stringStack = app.new StackOA<String>(1);
        assertTrue(stringStack.isEmpty());
        assertThrows(IllegalStateException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    public void testPushPopStackEA() {
        var app = new Ch6_2();
        var stringStack = app.new StackEA<String>(1);
        assertTrue(stringStack.isEmpty());
        stringStack.push("foo");
        assertFalse(stringStack.isEmpty());
        String result = stringStack.pop();
        assertEquals("foo", result);
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testPushPopStackOA() {
        var app = new Ch6_2();
        var stringStack = app.new StackOA<String>(1);
        assertTrue(stringStack.isEmpty());
        stringStack.push("foo");
        assertFalse(stringStack.isEmpty());
        String result = stringStack.pop();
        assertEquals("foo", result);
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testStackEA() {
        var app = new Ch6_2();
        var stringStack = app.new StackEA<String>(3);
        assertTrue(stringStack.isEmpty());
        var data = new String[]{"abc", "def", "ghi", "jkl"};
        for (var s : data) {
            stringStack.push(s);
        }
        assertFalse(stringStack.isEmpty());
        for (var i = 3; i >= 0; i--) {
            assertEquals(data[i], stringStack.pop());
        }
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testStackOA() {
        var app = new Ch6_2();
        var stringStack = app.new StackOA<String>(3);
        assertTrue(stringStack.isEmpty());
        var data = new String[]{"abc", "def", "ghi", "jkl"};
        for (var s : data) {
            stringStack.push(s);
        }
        assertFalse(stringStack.isEmpty());
        for (var i = 3; i >= 0; i--) {
            assertEquals(data[i], stringStack.pop());
        }
        assertTrue(stringStack.isEmpty());
    }
}

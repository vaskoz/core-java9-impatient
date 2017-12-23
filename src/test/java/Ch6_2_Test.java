import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch6_2_Test {

    @Test
    public void testBadStackEASize() {
        Ch6_2 app = new Ch6_2();
        assertThrows(IllegalArgumentException.class, () -> {
            Ch6_2.StackEA<String> stringStack = app.new StackEA<>(0);
        });
    }

    @Test
    public void testBadStackOASize() {
        Ch6_2 app = new Ch6_2();
        assertThrows(IllegalArgumentException.class, () -> {
            Ch6_2.StackOA<String> stringStack = app.new StackOA<>(0);
        });
    }

    @Test
    public void testPopEmptyStackEA() {
        Ch6_2 app = new Ch6_2();
        Ch6_2.StackEA<String> stringStack = app.new StackEA<>(1);
        assertTrue(stringStack.isEmpty());
        assertThrows(IllegalStateException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    public void testPopEmptyStackOA() {
        Ch6_2 app = new Ch6_2();
        Ch6_2.StackOA<String> stringStack = app.new StackOA<>(1);
        assertTrue(stringStack.isEmpty());
        assertThrows(IllegalStateException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    public void testPushPopStackEA() {
        Ch6_2 app = new Ch6_2();
        Ch6_2.StackEA<String> stringStack = app.new StackEA<>(1);
        assertTrue(stringStack.isEmpty());
        stringStack.push("foo");
        assertFalse(stringStack.isEmpty());
        String result = stringStack.pop();
        assertEquals("foo", result);
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testPushPopStackOA() {
        Ch6_2 app = new Ch6_2();
        Ch6_2.StackOA<String> stringStack = app.new StackOA<>(1);
        assertTrue(stringStack.isEmpty());
        stringStack.push("foo");
        assertFalse(stringStack.isEmpty());
        String result = stringStack.pop();
        assertEquals("foo", result);
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testStackEA() {
        Ch6_2 app = new Ch6_2();
        Ch6_2.StackEA<String> stringStack = app.new StackEA<>(3);
        assertTrue(stringStack.isEmpty());
        String[] data = {"abc", "def", "ghi", "jkl"};
        for (String s : data) {
            stringStack.push(s);
        }
        assertFalse(stringStack.isEmpty());
        for (int i = 3; i >= 0; i--) {
            assertEquals(data[i], stringStack.pop());
        }
        assertTrue(stringStack.isEmpty());
    }

    @Test
    public void testStackOA() {
        Ch6_2 app = new Ch6_2();
        Ch6_2.StackOA<String> stringStack = app.new StackOA<>(3);
        assertTrue(stringStack.isEmpty());
        String[] data = {"abc", "def", "ghi", "jkl"};
        for (String s : data) {
            stringStack.push(s);
        }
        assertFalse(stringStack.isEmpty());
        for (int i = 3; i >= 0; i--) {
            assertEquals(data[i], stringStack.pop());
        }
        assertTrue(stringStack.isEmpty());
    }
}

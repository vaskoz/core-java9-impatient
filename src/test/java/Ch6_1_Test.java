import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch6_1_Test {

    @Test
    public void testBadStackSize() {
        Ch6_1 app = new Ch6_1();
        assertThrows(IllegalArgumentException.class, () -> {
            Ch6_1.Stack<String> stringStack = app.new Stack<>(-1);
        });
    }

    @Test
    public void testPopEmptyStack() {
        Ch6_1 app = new Ch6_1();
        Ch6_1.Stack<String> stringStack = app.new Stack<>(1);
        assertThrows(IllegalStateException.class, () -> {
            stringStack.pop();
        });
    }

    @Test
    public void testPushPopStack() {
        Ch6_1 app = new Ch6_1();
        Ch6_1.Stack<String> stringStack = app.new Stack<>(1);
        stringStack.push("foo");
        String result = stringStack.pop();
        assertEquals("foo", result);
    }

    @Test
    public void testStack() {
        Ch6_1 app = new Ch6_1();
        Ch6_1.Stack<String> stringStack = app.new Stack<>(5);
        String[] data = {"abc", "def", "ghi"};
        for (String s : data) {
            stringStack.push(s);
        }
        for (int i = 2; i >= 0; i--) {
            assertEquals(data[i], stringStack.pop());
        }
    }
}

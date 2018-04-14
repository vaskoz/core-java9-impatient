import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch6_14_Test {
    @Test
    public void testCloseAllNoExceptions() {
        List<AutoCloseable> elems = List.of(() -> {
        }, () -> {
        }, () -> {
        });
    }

    @Test
    public void testCloseAllOneException() {
        var myException = new Exception("I can't close");
        List<AutoCloseable> elems = List.of(() -> {
        }, () -> {
        }, () -> {
            throw myException;
        });
        Throwable throwable = assertThrows(Exception.class, () -> Ch6_14.closeAll(elems));
        assertEquals(myException.getMessage(), throwable.getMessage());
        throwable = throwable.getCause();
        assertNull(throwable);
    }

    @Test
    public void testCloseAllExceptions() {
        var third = new Exception("I can't close third");
        var second = new Exception("I can't close second");
        var first = new Exception("I can't close first");
        List<AutoCloseable> elems = List.of(() -> {
            throw first;
        }, () -> {
            throw second;
        }, () -> {
            throw third;
        });
        Throwable throwable = assertThrows(Exception.class, () -> Ch6_14.closeAll(elems));
        assertEquals(third.getMessage(), throwable.getMessage());
        throwable = throwable.getCause();
        assertEquals(second.getMessage(), throwable.getMessage());
        throwable = throwable.getCause();
        assertEquals(first.getMessage(), throwable.getMessage());
        throwable = throwable.getCause();
        assertNull(throwable);
    }
}

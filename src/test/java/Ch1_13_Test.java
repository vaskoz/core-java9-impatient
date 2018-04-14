import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch1_13_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private ByteArrayOutputStream out;

    @BeforeAll
    static void saveOriginals() {
        originalOut = System.out;
        originalIn = System.in;
    }

    @AfterAll
    static void restoreOriginals() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @BeforeEach
    void setupInput() {
        this.out = new ByteArrayOutputStream(300);
        System.setOut(new PrintStream(this.out));
    }

    @Test
    void check() {
        Ch1_13.main(null);
        var parts = this.out.toString().trim().split(" ");
        assertEquals(6, parts.length);
        var last = 0;
        for (String part : parts) {
            var val = Integer.valueOf(part);
            assertTrue(val >= last);
            last = val;
        }
    }
}

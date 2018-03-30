import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_11_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String input = "µaåjqç";
    private final String want = "µ \\u00b5\n" +
            "å \\u00e5\n" +
            "ç \\u00e7\n";
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
        var in = new ByteArrayInputStream(input.getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
        System.setIn(in);
    }

    @Test
    void check() {
        Ch1_11.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

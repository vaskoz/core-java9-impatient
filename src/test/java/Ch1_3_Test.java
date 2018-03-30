import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_3_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;

    private ByteArrayOutputStream out;

    private final String want = "Largest using ?: 10\n" +
            "Largest using Math.max: 10\n";

    @BeforeAll
    static void saveOriginals() {
        originalOut = System.out;
        originalIn = System.in;
    }

    @BeforeEach
    void setupInput() {
        var in = new ByteArrayInputStream("4 8 10".getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setIn(in);
        System.setOut(new PrintStream(this.out));
    }

    @AfterAll
    static void restoreOriginals() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void check() {
        Ch1_3.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_8_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String input = "i luv code";
    private final String want = "i luv code\n" +
            "i luv cod\n" +
            "i luv co\n" +
            "i luv c\n" +
            "i luv\n" +
            "i lu\n" +
            "i l\n" +
            "i\n" +
            "luv code\n" +
            "luv cod\n" +
            "luv co\n" +
            "luv c\n" +
            "luv\n" +
            "lu\n" +
            "l\n" +
            "uv code\n" +
            "uv cod\n" +
            "uv co\n" +
            "uv c\n" +
            "uv\n" +
            "u\n" +
            "v code\n" +
            "v cod\n" +
            "v co\n" +
            "v c\n" +
            "v\n" +
            "code\n" +
            "cod\n" +
            "co\n" +
            "c\n" +
            "ode\n" +
            "od\n" +
            "o\n" +
            "de\n" +
            "d\n" +
            "e\n";
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
        Ch1_8.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

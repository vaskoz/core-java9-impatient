import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_14_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String input = "16 3 2 13\n" +
            "5 10 11 8\n" +
            "9 6 7 12\n" +
            "4 15 14 1\n\n";
    private final String want = "Is Magic?: true\n";
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
        InputStream in = new ByteArrayInputStream(input.getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
        System.setIn(in);
    }

    @Test
    void check() {
        Ch1_14.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_4_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;

    private ByteArrayOutputStream out;

    private final String want = "Smallest positive double: 4.90000e-324\n" +
            "Largest positive double: 1.79769e+308\n";

    @BeforeAll
    static void saveOriginals() {
        originalOut = System.out;
        originalIn = System.in;
    }

    @BeforeEach
    void setupInput() {
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
    }

    @AfterAll
    static void restoreOriginals() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void check() {
        Ch1_4.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

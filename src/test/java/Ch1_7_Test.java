import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_7_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String input = "4294967296 2";
    private final String want = "Unsigned sum: 4294967298\n" +
            "Difference: 4294967294\n" +
            "Product: 8589934592\n" +
            "Quotient: 2147483648\n" +
            "Remainder: 0\n";
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
        Ch1_7.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

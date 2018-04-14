import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch1_1_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;

    private ByteArrayOutputStream out;

    private final String want = "Binary: 1000000011011\n" +
            "Octal: 10033\n" +
            "Hexadecimal: 101b\n" +
            "Hexadecimal floating point: 0x1.fca5a873bcb19p-13\n";

    @BeforeAll
    static void saveOriginals() {
        originalOut = System.out;
        originalIn = System.in;
    }

    @BeforeEach
    void setupInput() {
        var in = new ByteArrayInputStream("4123".getBytes());
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
        Ch1_1.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

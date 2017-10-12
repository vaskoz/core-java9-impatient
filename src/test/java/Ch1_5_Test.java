import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_5_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;

    private ByteArrayOutputStream out;

    private final String want = "Double 1.0 + Integer.MAX_VALUE 2.14748e+09 as int 2147483647 Integer.MAX_VALUE 2147483647\n" +
            "Double 2000000000.0 + Integer.MAX_VALUE 4.14748e+09 as int 2147483647 Integer.MAX_VALUE 2147483647\n";

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
        Ch1_5.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch2_5_Test {
    private static PrintStream originalOut;
    private ByteArrayOutputStream out;
    private final String want = "(2.0, 3.5)\n";

    @BeforeAll
    static void saveOriginals() {
        originalOut = System.out;
    }

    @AfterAll
    static void restoreOriginals() {
        System.setOut(originalOut);
    }

    @BeforeEach
    void setupInput() {
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
    }

    @Test
    void check() {
        Ch2_5.main(null);
        assertEquals(want.toString(), this.out.toString());
    }
}

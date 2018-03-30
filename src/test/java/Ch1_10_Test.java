import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_10_Test {
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
        this.out = new ByteArrayOutputStream(1000);
        System.setOut(new PrintStream(this.out));
    }

    @Test
    void check() {
        Ch1_10.main(null);
        var result = this.out.toString();
        var parts = result.split(" ");
        var v1 = Long.parseLong(parts[0]);
        var v2 = Long.parseLong(parts[1].trim(), 36);
        assertEquals(v1, v2);
    }
}

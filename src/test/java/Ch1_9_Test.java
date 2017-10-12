import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_9_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String want = "new String(\"my string\").equals(new String(\"my string\")) should be true is true\n" +
            "new String(\"my string\") == new String(\"my string\") should be false is false\n";
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
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
    }

    @Test
    void check() {
        Ch1_9.main(null);
        assertEquals(this.want, this.out.toString());
    }
}

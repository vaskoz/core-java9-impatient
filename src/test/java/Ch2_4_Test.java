import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch2_4_Test {
    private static PrintStream originalOut;
    private ByteArrayOutputStream out;
    private final String want = "Before 'cantSwap(a,b)' a=1 and b=2\n" +
            "After 'cantSwap(a,b)' a=1 and b=2\n" +
            "Before 'canSwap(ah,bh)' a=1 and b=2\n" +
            "After 'canSwap(ah,bh)' a=2 and b=1\n";

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
        this.out = new ByteArrayOutputStream(50000);
        System.setOut(new PrintStream(this.out));
    }

    @Test
    void check() {
        Ch2_4.main(null);
        assertEquals(want.toString(), this.out.toString());
    }
}

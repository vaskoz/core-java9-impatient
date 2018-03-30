import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_14_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String magicInput = "16 3 2 13\n" +
            "5 10 11 8\n" +
            "9 6 7 12\n" +
            "4 15 14 1\n\n";
    private final String notMagicRow = "17 3 2 13\n" +
            "5 10 11 8\n" +
            "9 6 7 12\n" +
            "4 15 14 1\n\n";
    ;
    private final String notMagicColumn = "16 3 2 13\n" +
            "5 10 11 8\n" +
            "9 6 7 12\n" +
            "5 15 14 1\n\n";
    ;
    private final String want = "Is Magic?: ";
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

    @Test
    void check() {
        var in = new ByteArrayInputStream(magicInput.getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
        System.setIn(in);
        Ch1_14.main(null);
        assertEquals(this.want + "true\n", this.out.toString());
    }

    @Test
    void checkNotMagicRow() {
        var in = new ByteArrayInputStream(notMagicRow.getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
        System.setIn(in);
        Ch1_14.main(null);
        assertEquals(this.want + "false\n", this.out.toString());
    }

    @Test
    void checkNotMagicColumn() {
        var in = new ByteArrayInputStream(notMagicColumn.getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
        System.setIn(in);
        Ch1_14.main(null);
        assertEquals(this.want + "false\n", this.out.toString());
    }

}

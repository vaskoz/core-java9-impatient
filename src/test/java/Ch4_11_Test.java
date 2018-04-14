import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch4_11_Test {
    private PrintStream realStdOut;

    @BeforeEach
    public void setupStandardOut() {
        this.realStdOut = System.out;
    }

    @AfterEach
    public void restoreStandardOut() {
        System.setOut(this.realStdOut);
    }

    @Test
    public void reflectiveHelloWorld() {
        var out = new ByteArrayOutputStream(100);
        System.setOut(new PrintStream(out));
        try {
            Ch4_11.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(Ch4_11.message + "\n", out.toString());
    }
}

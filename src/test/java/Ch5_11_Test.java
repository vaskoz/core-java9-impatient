import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch5_11_Test {
    private PrintStream originalOut;
    private ByteArrayOutputStream out;

    @BeforeEach
    public void setup() {
        this.originalOut = System.out;
        this.out = new ByteArrayOutputStream(10_000);
        System.setOut(new PrintStream(this.out));
    }

    @AfterEach
    public void teardown() {
        System.setOut(this.originalOut);
        this.out = null;
    }

    @Test
    public void testFactorial() {
        assertThrows(IllegalArgumentException.class, () -> Ch5_11.factorial(-1));
        assertEquals(BigInteger.valueOf(3628800), Ch5_11.factorial(10));
        var want = "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:12)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n" +
                "Ch5_11.factorial(Ch5_11.java:17)\n";
        assertEquals(want, this.out.toString());
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch2_9_Test {
    private static PrintStream originalOut;
    private ByteArrayOutputStream out;
    private final String want = "Fuel level is 8.628571\n" +
            "Current position is 100.500000\n";

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
        Ch2_9.main(null);
        assertEquals(want.toString(), this.out.toString());
    }

    @Test
    void driveFar() {
        var c = new Ch2_9.Car(10, 1);
        c.drive(9);
        assertEquals(0.1, c.getFuelLevel(), 0.0001);
        assertEquals(9.0, c.getDistance(), 0.0001);
        c.drive(0.99);
        assertEquals(0.0, c.getFuelLevel(), 0.02);
        assertEquals(10.0, c.getDistance(), 0.02);
        c.refuel(10);
        c.drive(10);
        assertEquals(9.0, c.getFuelLevel(), 0.02);
        assertEquals(20.0, c.getDistance(), 0.02);
    }

    @Test
    void driveTooFar() {
        var c = new Ch2_9.Car(10, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            c.drive(10.1);
        });
    }
}

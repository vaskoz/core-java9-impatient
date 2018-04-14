import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_9_Test {
    private ByteArrayOutputStream out;

    @BeforeEach
    void setupInput() {
        this.out = new ByteArrayOutputStream(5000);
        System.setOut(new PrintStream(this.out));
    }

    @Test
    public void testGreeterThreads() throws Exception {
        Ch3_9.main();
        var output = this.out.toString();
        var parts = output.split("\n");
        var toms = Arrays.stream(parts).filter(s -> s.contains("tom")).count();
        var tims = Arrays.stream(parts).filter(s -> s.contains("tim")).count();
        assertEquals(10, toms);
        assertEquals(5, tims);
    }
}

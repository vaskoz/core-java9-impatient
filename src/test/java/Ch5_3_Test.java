import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch5_3_Test {
    private PrintStream originalOut;
    private PrintStream originalErr;
    private ByteArrayOutputStream err;
    private ByteArrayOutputStream out;

    @BeforeEach
    public void setup() {
        originalOut = System.out;
        originalErr = System.err;
        out = new ByteArrayOutputStream();
        err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void teardown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        out = null;
        err = null;
    }

    @Test
    public void testMainNoArgs() {
        Ch5_3.main();
        assertTrue(err.toString().contains("must provide filename to read doubles"));
    }

    @Test
    public void testMainFileNotFound() throws IOException {
        Ch5_3.main("i'm not a real file");
        assertTrue(err.toString().contains("File \"i'm not a real file\" could not be found"));
    }

    @Test
    public void testMain() throws IOException {
        var f = File.createTempFile("testReadValues", "data");
        var expected = new ArrayList<>(Arrays.asList(2.1, 3.2, 4.3, 5.4));
        var fw = new FileWriter(f);
        for (var d : expected) {
            fw.write(d.toString() + " ");
        }
        fw.close();
        Ch5_3.main(f.getAbsolutePath());
        var d = Double.parseDouble(out.toString());
        assertEquals(15.0, d, 0.001);
        f.deleteOnExit();
    }
}

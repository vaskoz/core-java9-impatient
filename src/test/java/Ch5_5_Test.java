import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch5_5_Test {
    private PrintStream originalErr;
    private ByteArrayOutputStream err;

    @BeforeEach
    public void setup() {
        originalErr = System.err;
        err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void teardown() {
        System.setErr(originalErr);
        err = null;
    }

    @Test
    public void testCopyLowercase() throws IOException {
        File src = File.createTempFile("inputStrings", "data");
        File dest = File.createTempFile("outputStrings", "data");
        List<String> input = List.of("HI", "There", "EveryBody");
        FileWriter fw = new FileWriter(src);
        for (String s : input) {
            fw.write(s + " ");
        }
        fw.close();
        Ch5_5.copyLowerCase(src, dest);
        Scanner output = new Scanner(dest);
        for (String s : input) {
            assertEquals(s.toLowerCase(), output.next());
        }
        assertFalse(output.hasNext());
        assertTrue(err.toString().isEmpty());
        src.deleteOnExit();
        dest.deleteOnExit();
    }

    @Test
    public void testMissingFiles() throws IOException {
        Ch5_5.copyLowerCase(null, null);
        assertTrue(err.toString().contains("File could not be found"));
        err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
        Ch5_5.copyLowerCase(new File("not here"), new File("not there"));
        assertTrue(err.toString().contains("File could not be found"));
    }
}

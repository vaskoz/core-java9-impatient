import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch7_8_Test {
    private static PrintStream originalStdout;

    @BeforeAll
    public static void setup() {
        originalStdout = System.out;
    }

    @AfterAll
    public static void teardown() {
        System.setOut(originalStdout);
    }

    @Test
    public void processTestFile() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> Ch7_8.main());
        assertThrows(FileNotFoundException.class, () -> Ch7_8.main("i'm not a real file"));

        var f = File.createTempFile("words", "txt");
        var fw = new BufferedWriter(new FileWriter(f));
        var text = new String[]{"hi there buddy", "buddy eats pizza", "hi buddy you like pizza", "no pizza for me"};
        for (var line : text) {
            fw.write(line);
            fw.newLine();
        }
        fw.flush();
        var out = new ByteArrayOutputStream(5000);
        System.setOut(new PrintStream(out));
        Ch7_8.main(f.getAbsolutePath());

        var want = "Word is: hi with lines: 1,3\n" +
                "Word is: no with lines: 4\n" +
                "Word is: pizza with lines: 2,3,4\n" +
                "Word is: eats with lines: 2\n" +
                "Word is: like with lines: 3\n" +
                "Word is: there with lines: 1\n" +
                "Word is: for with lines: 4\n" +
                "Word is: me with lines: 4\n" +
                "Word is: buddy with lines: 1,2,3\n" +
                "Word is: you with lines: 3\n";
        assertEquals(want, out.toString());
        f.deleteOnExit();
    }
}

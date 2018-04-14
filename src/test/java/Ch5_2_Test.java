import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch5_2_Test {
    @Test
    public void testSumOfValuesBadFilename() {
        var app = new Ch5_2();
        var exception = assertThrows(IllegalArgumentException.class, () -> {
            app.sumOfValues(null);
        });
        assertEquals("invalid filename", exception.getMessage());
        var exception2 = assertThrows(IllegalArgumentException.class, () -> {
            app.sumOfValues("");
        });
        assertEquals("invalid filename", exception2.getMessage());
    }

    @Test
    public void testSumOfValues() throws IOException {
        var app = new Ch5_2();
        var f = File.createTempFile("testReadValues", "data");
        var expected = new ArrayList<>(Arrays.asList(2.1, 3.2, 4.3, 5.4));
        var fw = new FileWriter(f);
        for (var d : expected) {
            fw.write(d.toString() + " ");
        }
        fw.close();
        var result = app.sumOfValues(f.getAbsolutePath());
        assertEquals(15.0, result, 0.001);
        f.deleteOnExit();
    }
}

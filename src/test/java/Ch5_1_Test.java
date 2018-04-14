import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch5_1_Test {
    @Test
    public void testReadValuesBadFilename() {
        var app = new Ch5_1();
        var exception = assertThrows(IllegalArgumentException.class, () -> {
            app.readValues(null);
        });
        assertEquals("invalid filename", exception.getMessage());
        var exception2 = assertThrows(IllegalArgumentException.class, () -> {
            app.readValues("");
        });
        assertEquals("invalid filename", exception2.getMessage());
    }

    @Test
    public void testReadValues() throws IOException {
        var app = new Ch5_1();
        var f = File.createTempFile("testReadValues", "data");
        var expected = new ArrayList<>(Arrays.asList(2.1, 3.2, 4.3, 5.4));
        var fw = new FileWriter(f);
        for (var d : expected) {
            fw.write(d.toString() + " ");
        }
        fw.close();
        var data = app.readValues(f.getAbsolutePath());
        assertEquals(expected, data);
        f.deleteOnExit();
    }

    @Test
    public void testReadValuesBad() throws IOException {
        var app = new Ch5_1();
        var f = File.createTempFile("testReadValues", "data");
        var expected = new ArrayList<>(Arrays.asList(2.1));
        var fw = new FileWriter(f);
        for (var d : expected) {
            fw.write(d.toString() + " ");
            fw.write("apple ");
        }
        fw.write("5.6 ");
        fw.close();
        var data = app.readValues(f.getAbsolutePath());
        assertEquals(expected, data);
        f.deleteOnExit();
    }
}

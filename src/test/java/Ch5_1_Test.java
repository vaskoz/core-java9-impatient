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
        Ch5_1 app = new Ch5_1();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            app.readValues(null);
        });
        assertEquals("invalid filename", exception.getMessage());
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> {
            app.readValues("");
        });
        assertEquals("invalid filename", exception2.getMessage());
    }

    @Test
    public void testReadValues() throws IOException {
        Ch5_1 app = new Ch5_1();
        File f = File.createTempFile("testReadValues", "data");
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(2.1, 3.2, 4.3, 5.4));
        FileWriter fw = new FileWriter(f);
        for (Double d : expected) {
            fw.write(d.toString() + " ");
        }
        fw.close();
        ArrayList<Double> data = app.readValues(f.getAbsolutePath());
        assertEquals(expected, data);
        f.deleteOnExit();
    }

    @Test
    public void testReadValuesBad() throws IOException {
        Ch5_1 app = new Ch5_1();
        File f = File.createTempFile("testReadValues", "data");
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(2.1));
        FileWriter fw = new FileWriter(f);
        for (Double d : expected) {
            fw.write(d.toString() + " ");
            fw.write("apple ");
        }
        fw.write("5.6 ");
        fw.close();
        ArrayList<Double> data = app.readValues(f.getAbsolutePath());
        assertEquals(expected, data);
        f.deleteOnExit();
    }
}

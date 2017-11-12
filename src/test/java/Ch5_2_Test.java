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
        Ch5_2 app = new Ch5_2();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            app.sumOfValues(null);
        });
        assertEquals("invalid filename", exception.getMessage());
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> {
            app.sumOfValues("");
        });
        assertEquals("invalid filename", exception2.getMessage());
    }

    @Test
    public void testSumOfValues() throws IOException {
        Ch5_2 app = new Ch5_2();
        File f = File.createTempFile("testReadValues", "data");
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(2.1, 3.2, 4.3, 5.4));
        FileWriter fw = new FileWriter(f);
        for (Double d : expected) {
            fw.write(d.toString() + " ");
        }
        fw.close();
        double result = app.sumOfValues(f.getAbsolutePath());
        assertEquals(15.0, result, 0.001);
        f.deleteOnExit();
    }
}

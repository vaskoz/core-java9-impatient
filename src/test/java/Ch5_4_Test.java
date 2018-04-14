import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch5_4_Test {
    @Test
    public void testSumOfValuesBadFilename() {
        var app = new Ch5_4();
        assertEquals(Ch5_4.Status.FileNotFound, app.sumOfValues(null, List.of()));
        assertEquals(Ch5_4.Status.FileNotFound, app.sumOfValues("", List.of()));
        assertEquals(Ch5_4.Status.FileNotFound, app.sumOfValues("i don't exist", List.of()));
    }

    @Test
    public void testSumOfValues() throws IOException {
        var app = new Ch5_4();
        var f = File.createTempFile("testReadValues", "data");
        var expected = new ArrayList<>(Arrays.asList(2.1, 3.2, 4.3, 5.4));
        var fw = new FileWriter(f);
        for (var d : expected) {
            fw.write(d.toString() + " ");
        }
        fw.close();
        var data = new ArrayList<Double>(5);
        assertEquals(Ch5_4.Status.Success, app.sumOfValues(f.getAbsolutePath(), data));
        assertEquals(15.0, (double) data.get(data.size() - 1), 0.001);
        f.deleteOnExit();
    }
}

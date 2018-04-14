import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch12_7_Test {
    private static List<LocalDateTime> dateTimes;

    @BeforeAll
    public static void setup() {
        dateTimes = new ArrayList<>(5);
        dateTimes.add(LocalDateTime.of(2017, 1, 1, 0, 0));
        dateTimes.add(LocalDateTime.of(2017, 2, 1, 0, 0));
        dateTimes.add(LocalDateTime.of(2017, 2, 1, 1, 0));
        dateTimes.add(LocalDateTime.of(2017, 3, 1, 0, 0));
        dateTimes.add(LocalDateTime.of(2018, 1, 1, 0, 0));
    }

    @AfterAll
    public static void teardown() {
        dateTimes.clear();
        dateTimes = null;
    }

    @Test
    public void testOverlap() {
        var app = new Ch12_7();
        var ti = app.new TimeInterval(dateTimes.get(0), dateTimes.get(2));
        var other = app.new TimeInterval(dateTimes.get(1), dateTimes.get(2));
        assertTrue(ti.overlap(other));
        ti = app.new TimeInterval(dateTimes.get(1), dateTimes.get(1));
        other = app.new TimeInterval(dateTimes.get(0), dateTimes.get(2));
        assertTrue(ti.overlap(other));
        ti = app.new TimeInterval(dateTimes.get(1), dateTimes.get(1));
        other = app.new TimeInterval(dateTimes.get(0), dateTimes.get(1));
        assertFalse(ti.overlap(other));
        ti = app.new TimeInterval(dateTimes.get(0), dateTimes.get(1));
        other = app.new TimeInterval(dateTimes.get(2), dateTimes.get(3));
        assertFalse(ti.overlap(other));
        other = app.new TimeInterval(dateTimes.get(0), dateTimes.get(1));
        ti = app.new TimeInterval(dateTimes.get(2), dateTimes.get(3));
        assertFalse(ti.overlap(other));
    }

    @Test
    public void testBadArguments() {
        var app = new Ch12_7();
        assertThrows(IllegalArgumentException.class, () ->
                app.new TimeInterval(
                        LocalDateTime.of(2018, 1, 1, 1, 1),
                        LocalDateTime.of(2017, 1, 1, 1, 1)));
    }
}

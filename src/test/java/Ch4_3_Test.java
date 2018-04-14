import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch4_3_Test {
    private static Ch4_3 app;

    @BeforeAll
    public static void setup() {
        app = new Ch4_3();
    }

    @AfterAll
    public static void teardown() {
        app = null;
    }

    @Test
    public void testPoint() {
        var p1 = app.new Point(1, 2);
        assertEquals(1, p1.getX());
        assertEquals(2, p1.getY());
        var p2 = app.new Point(1, 2);
        assertTrue(p1.equals(p2));
        assertEquals(p1.hashCode(), p2.hashCode());
        assertEquals(p1.toString(), p2.toString());
    }

    @Test
    public void testLabeledPoint() {
        var lp1 = app.new LabeledPoint(1, 2, "foo");
        assertEquals(1, lp1.getX());
        assertEquals(2, lp1.getY());
        assertEquals("foo", lp1.getLabel());
        var lp2 = app.new LabeledPoint(1, 2, "foo");
        assertTrue(lp1.equals(lp2));
        assertEquals(lp1.hashCode(), lp2.hashCode());
        assertEquals(lp1.toString(), lp2.toString());
    }
}

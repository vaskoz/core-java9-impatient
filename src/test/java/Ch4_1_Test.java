import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch4_1_Test {
    private static Ch4_1 app;

    @BeforeAll
    public static void setup() {
        app = new Ch4_1();
    }

    @AfterAll
    public static void teardown() {
        app = null;
    }

    @Test
    public void testPoint() {
        var p = app.new Point(1, 2);
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void testLabeledPoint() {
        var labeledPoint = app.new LabeledPoint(1, 2, "foo");
        assertEquals(1, labeledPoint.getX());
        assertEquals(2, labeledPoint.getY());
        assertEquals("foo", labeledPoint.getLabel());
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Ch4_5_Test {
    private static Ch4_5 app;

    @BeforeAll
    public static void setup() {
        app = new Ch4_5();
    }

    @AfterAll
    public static void teardown() {
        app = null;
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 1.0",
            "1.0, 5.0, 0.5",
            "-1.0, -1.0, 0.1",
            "-5.0, 5.0, 5.0"})
    public void testCircleClone(double centerX, double centerY, double radius) throws CloneNotSupportedException {
        Ch4_5.Point center = app.new Point(centerX, centerY);
        Ch4_5.Circle circle = app.new Circle(center, radius);
        Object clone = circle.clone();
        assertFalse(circle == clone);
        assertEquals(circle, clone);
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 4.0",
            "-5.0, 5.0, 5.0, 10.0"})
    public void testRectangleClone(double topleftX, double topleftY, double width, double height) throws CloneNotSupportedException {
        Ch4_5.Point topleft = app.new Point(topleftX, topleftY);
        Ch4_5.Rectangle rectangle = app.new Rectangle(topleft, width, height);
        Object clone = rectangle.clone();
        assertFalse(rectangle == clone);
        assertEquals(rectangle, clone);
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 0.0, 2.0, 0.0, 4.0, 0.0",
            "-1.0, -1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0"})
    public void testLineClone(double fromX, double fromY, double toX, double toY) throws CloneNotSupportedException {
        Ch4_5.Point from = app.new Point(fromX, fromY);
        Ch4_5.Point to = app.new Point(toX, toY);
        Ch4_5.Line line = app.new Line(from, to);
        Object clone = line.clone();
        assertFalse(line == clone);
        assertEquals(line, clone);
    }
}

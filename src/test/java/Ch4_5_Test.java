import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testCircleClone(double centerX, double centerY, double radius) {
        var center = app.new Point(centerX, centerY);
        var circle = app.new Circle(center, radius);
        var clone = circle.clone();
        assertFalse(circle == clone);
        assertEquals(circle, clone);
        assertEquals(circle.hashCode(), clone.hashCode());
        assertEquals(circle.getCenter(), clone.getCenter());
        circle.moveBy(1.0, 1.0);
        clone.moveBy(1.0, 1.0);
        assertEquals(circle, clone);
        assertEquals(circle.hashCode(), clone.hashCode());
        assertEquals(circle.getCenter(), clone.getCenter());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 4.0",
            "-5.0, 5.0, 5.0, 10.0"})
    public void testRectangleClone(double topleftX, double topleftY, double width, double height) {
        var topleft = app.new Point(topleftX, topleftY);
        var rectangle = app.new Rectangle(topleft, width, height);
        var clone = rectangle.clone();
        assertFalse(rectangle == clone);
        assertEquals(rectangle, clone);
        assertEquals(rectangle.hashCode(), clone.hashCode());
        assertEquals(rectangle.getCenter(), clone.getCenter());
        rectangle.moveBy(1.0, 1.0);
        clone.moveBy(1.0, 1.0);
        assertEquals(rectangle, clone);
        assertEquals(rectangle.hashCode(), clone.hashCode());
        assertEquals(rectangle.getCenter(), clone.getCenter());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 0.0", "2.0, 0.0, 4.0, 0.0",
            "-1.0, -1.0, 1.0, 1.0", "1.0, 1.0, 1.0, 1.0"})
    public void testLineClone(double fromX, double fromY, double toX, double toY) {
        var from = app.new Point(fromX, fromY);
        var to = app.new Point(toX, toY);
        var line = app.new Line(from, to);
        var clone = line.clone();
        assertFalse(line == clone);
        assertEquals(line, clone);
        assertEquals(line.hashCode(), clone.hashCode());
        assertEquals(line.getCenter(), clone.getCenter());
        line.moveBy(1.0, 1.0);
        clone.moveBy(1.0, 1.0);
        assertEquals(line, clone);
        assertEquals(line.hashCode(), clone.hashCode());
        assertEquals(line.getCenter(), clone.getCenter());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0", "4.0, 0.0", "2.0, 0.0", "4.0, 0.0",
            "-1.0, -1.0", "1.0, 1.0", "1.0, 1.0", "1.0, 1.0"})
    public void testPointClone(double x, double y) {
        var point = app.new Point(x, y);
        var clone = point.clone();
        assertFalse(point == clone);
        assertEquals(point, clone);
        assertEquals(point.hashCode(), clone.hashCode());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0"})
    public void testShapeClone(double x, double y) {
        var weirdShapeUp5Right5 = app.new Shape(app.new Point(x, y)) {
            @Override
            public Ch4_5.Point getCenter() {
                return app.new Point(this.point.getX() + 5, this.point.getY() + 5);
            }
        };
        assertThrows(CloneNotSupportedException.class, weirdShapeUp5Right5::clone);
    }
}

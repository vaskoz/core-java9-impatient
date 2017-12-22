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
        Ch4_5.Point center = app.new Point(centerX, centerY);
        Ch4_5.Circle circle = app.new Circle(center, radius);
        Ch4_5.Circle clone = circle.clone();
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
        Ch4_5.Point topleft = app.new Point(topleftX, topleftY);
        Ch4_5.Rectangle rectangle = app.new Rectangle(topleft, width, height);
        Ch4_5.Rectangle clone = rectangle.clone();
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
        Ch4_5.Point from = app.new Point(fromX, fromY);
        Ch4_5.Point to = app.new Point(toX, toY);
        Ch4_5.Line line = app.new Line(from, to);
        Ch4_5.Line clone = line.clone();
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
        Ch4_5.Point point = app.new Point(x, y);
        Ch4_5.Point clone = point.clone();
        assertFalse(point == clone);
        assertEquals(point, clone);
        assertEquals(point.hashCode(), clone.hashCode());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0"})
    public void testShapeClone(double x, double y) {
        Ch4_5.Shape weirdShapeUp5Right5 = app.new Shape(app.new Point(x, y)) {
            @Override
            public Ch4_5.Point getCenter() {
                return app.new Point(this.point.getX() + 5, this.point.getY() + 5);
            }
        };
        assertThrows(CloneNotSupportedException.class, weirdShapeUp5Right5::clone);
    }
}

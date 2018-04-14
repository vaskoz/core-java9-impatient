import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch4_4_Test {
    private static Ch4_4 app;

    @BeforeAll
    public static void setup() {
        app = new Ch4_4();
    }

    @AfterAll
    public static void teardown() {
        app = null;
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 1.0, 4.0, 4.0, 4.0, 4.0",
            "1.0, 5.0, 0.5, -1.0, -5.0, 0.0, 0.0",
            "-1.0, -1.0, 0.1, 2.0, 2.0, 1.0, 1.0",
            "-5.0, 5.0, 5.0, 10.0, -10.0, 5.0, -5.0"})
    public void testCircle(double centerX, double centerY, double radius, double moveX, double moveY, double expectedX, double expectedY) {
        var center = app.new Point(centerX, centerY);
        var circle = app.new Circle(center, radius);
        circle.moveBy(moveX, moveY);
        var newCenter = circle.getCenter();
        var expected = app.new Point(expectedX, expectedY);
        assertEquals(expected, newCenter);
        assertEquals(expected.hashCode(), newCenter.hashCode());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 4.0, 2.0, 2.0, 4.0, 0.0",
            "-5.0, 5.0, 5.0, 10.0, 1.0, 1.0, -1.5, 1.0"})
    public void testRectangle(double topleftX, double topleftY, double width, double height, double moveX, double moveY, double expectedX, double expectedY) {
        var topleft = app.new Point(topleftX, topleftY);
        var rectangle = app.new Rectangle(topleft, width, height);
        rectangle.moveBy(moveX, moveY);
        var newCenter = rectangle.getCenter();
        var expected = app.new Point(expectedX, expectedY);
        assertEquals(expected, newCenter);
        assertEquals(expected.hashCode(), newCenter.hashCode());
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 0.0, 2.0, 0.0, 4.0, 0.0",
            "-1.0, -1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0"})
    public void testLine(double fromX, double fromY, double toX, double toY, double moveX, double moveY, double expectedX, double expectedY) {
        var from = app.new Point(fromX, fromY);
        var to = app.new Point(toX, toY);
        var line = app.new Line(from, to);
        line.moveBy(moveX, moveY);
        var newCenter = line.getCenter();
        var expected = app.new Point(expectedX, expectedY);
        assertEquals(expected, newCenter);
        assertEquals(expected.hashCode(), newCenter.hashCode());
    }
}

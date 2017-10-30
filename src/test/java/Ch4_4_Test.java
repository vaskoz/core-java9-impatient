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
        Ch4_4.Point center = app.new Point(centerX, centerY);
        Ch4_4.Circle circle = app.new Circle(center, radius);
        circle.moveBy(moveX, moveY);
        Ch4_4.Point newCenter = circle.getCenter();
        assertEquals(app.new Point(expectedX, expectedY), newCenter);
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 4.0, 2.0, 2.0, 4.0, 0.0",
            "-5.0, 5.0, 5.0, 10.0, 1.0, 1.0, -1.5, 1.0"})
    public void testRectangle(double topleftX, double topleftY, double width, double height, double moveX, double moveY, double expectedX, double expectedY) {
        Ch4_4.Point topleft = app.new Point(topleftX, topleftY);
        Ch4_4.Rectangle rectangle = app.new Rectangle(topleft, width, height);
        rectangle.moveBy(moveX, moveY);
        Ch4_4.Point newCenter = rectangle.getCenter();
        assertEquals(app.new Point(expectedX, expectedY), newCenter);
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 4.0, 0.0, 2.0, 0.0, 4.0, 0.0",
            "-1.0, -1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0"})
    public void testLine(double fromX, double fromY, double toX, double toY, double moveX, double moveY, double expectedX, double expectedY) {
        Ch4_4.Point from = app.new Point(fromX, fromY);
        Ch4_4.Point to = app.new Point(toX, toY);
        Ch4_4.Line line = app.new Line(from, to);
        line.moveBy(moveX, moveY);
        Ch4_4.Point newCenter = line.getCenter();
        assertEquals(app.new Point(expectedX, expectedY), newCenter);
    }
}

import java.util.Objects;

public class Ch4_5 {
    class Point implements Cloneable {
        private final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public Point clone() {
            return new Point(this.x, this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            var point = (Point) o;

            if (Double.compare(point.x, x) != 0) return false;
            return Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            var temp = Double.doubleToLongBits(x);
            var result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            return 31 * result + (int) (temp ^ (temp >>> 32));
        }
    }

    abstract class Shape implements Cloneable {
        protected Point point;

        public Shape(Point point) {
            this.point = point;
        }

        @Override
        public Shape clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Please use the constructor");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            var shape = (Shape) o;
            return Objects.equals(point, shape.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point);
        }

        public void moveBy(double dx, double dy) {
            this.point = new Point(this.point.getX() + dx, this.point.getY() + dy);
        }

        public abstract Point getCenter();
    }

    class Circle extends Shape implements Cloneable {
        private final double radius;

        public Circle(Point center, double radius) {
            super(center);
            this.radius = radius;
        }

        @Override
        public Circle clone() {
            return new Circle(this.point, this.radius);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            var circle = (Circle) o;
            return Double.compare(circle.radius, radius) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), radius);
        }

        @Override
        public Point getCenter() {
            return this.point;
        }
    }

    class Rectangle extends Shape implements Cloneable {
        private final double width;
        private final double height;

        public Rectangle(Point topLeft, double width, double height) {
            super(topLeft);
            this.width = width;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            var rectangle = (Rectangle) o;
            return Double.compare(rectangle.width, width) == 0 &&
                    Double.compare(rectangle.height, height) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), width, height);
        }

        @Override
        public Rectangle clone() {
            return new Rectangle(this.point, this.width, this.height);
        }

        /**
         * This is how you calculate the center of a rectangle when you have the top-left point.
         *
         * @return the center point
         */
        @Override
        public Point getCenter() {
            var newX = (2 * this.point.getX() + this.width) / 2; // go positive X (right from left)
            var newY = (2 * this.point.getY() - this.height) / 2; // go negative Y (down from top)
            return new Point(newX, newY);
        }
    }

    class Line extends Shape implements Cloneable {
        private Point from;
        private Point to;

        public Line(Point from, Point to) {
            super(null);
            this.from = from;
            this.to = to;
            var centerX = (this.from.getX() + this.to.getX()) / 2;
            var centerY = (this.from.getY() + this.to.getY()) / 2;
            this.point = new Point(centerX, centerY);
        }

        @Override
        public Line clone() {
            return new Line(this.from, this.to);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            var line = (Line) o;
            return Objects.equals(from, line.from) &&
                    Objects.equals(to, line.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), from, to);
        }

        @Override
        public Point getCenter() {
            return this.point;
        }

        @Override
        public void moveBy(double dx, double dy) {
            super.moveBy(dx, dy);
            this.from = new Point(this.from.getX() + dx, this.from.getY() + dy);
            this.to = new Point(this.to.getX() + dx, this.to.getY() + dy);
        }
    }
}

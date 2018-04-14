public class Ch4_2 {
    class Point {
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
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class LabeledPoint extends Point {
        private final String label;

        public LabeledPoint(double x, double y, String label) {
            super(x, y);
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            var that = (LabeledPoint) o;

            return label.equals(that.label);
        }

        @Override
        public int hashCode() {
            var result = super.hashCode();
            return 31 * result + label.hashCode();
        }

        @Override
        public String toString() {
            return "LabeledPoint{" +
                    "x=" + this.getX() +
                    ", y=" + this.getY() +
                    ", label='" + label + '\'' +
                    '}';
        }

        public String getLabel() {
            return label;
        }
    }
}

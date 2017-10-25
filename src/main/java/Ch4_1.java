public class Ch4_1 {
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
    }

    class LabeledPoint extends Point {
        private final String label;

        public LabeledPoint(double x, double y, String label) {
            super(x, y);
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}

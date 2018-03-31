public class Ch2_6 {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p);
    }

    private static class Point {
        private double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Translate the position of this point.
         *
         * @param x
         * @param y
         * @return mutates the existing Point
         */
        public Point translate(double x, double y) {
            this.x += x;
            this.y += y;
            return this;
        }

        /**
         * Scale the position of this point.
         *
         * @param scale
         * @return mutates the existing Point
         */
        public Point scale(double scale) {
            this.x *= scale;
            this.y *= scale;
            return this;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
}

public class Ch2_5 {
    private static class Point {
        private double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Translates a Point to a new position
         *
         * @param x
         * @param y
         * @return a new Point that has been translated
         */
        public Point translate(double x, double y) {
            return new Point(this.x + x, this.y + y);
        }

        /**
         * Scale the point
         *
         * @param scale factor to scale x & y by
         * @return a new Point that has been scaled
         */
        public Point scale(double scale) {
            return new Point(this.x * scale, this.y * scale);
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    public static void main(String[] args) {
        var p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p);
    }
}

public class Ch2_9 {
    public static void main(String[] args) {
        Car c = new Car(35.0);
        c.drive(100.5);
        c.refuel(1.5);
        System.out.printf("Fuel level is %f\n", c.getFuelLevel());
        System.out.printf("Current position is %f\n", c.getDistance());
    }

    static class Car {
        private final double mpg;
        private double gallons;
        private double distance = 0.0;

        public Car(double mpg, double gallons) {
            this.mpg = mpg;
            this.gallons = gallons;
        }

        public Car(double mpg) {
            this(mpg, 10);
        }

        public void drive(double miles) {
            var gallonsNeeded = miles / this.mpg;
            if (gallonsNeeded > this.gallons) {
                var msg = String.format("Insufficient fuel for this journey. " + "" +
                        "To drive %f miles you need %f gallons, but only have %f gallons", miles, gallonsNeeded, this.gallons);
                throw new IllegalArgumentException(msg);
            }
            this.distance += miles;
            this.gallons -= gallonsNeeded;
        }

        public void refuel(double gallons) {
            this.gallons += gallons;
        }

        public double getFuelLevel() {
            return this.gallons;
        }

        public double getDistance() {
            return distance;
        }
    }
}

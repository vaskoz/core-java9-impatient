import java.util.Arrays;
import java.util.OptionalDouble;

public class Ch3_1 {
    interface Measurable {
        double getMeasure();
    }

    static class Employee implements Measurable {
        private final double salary;

        public Employee(double salary) {
            this.salary = salary;
        }

        @Override
        public double getMeasure() {
            return this.salary;
        }

        static double average(Measurable[] objects) {
            var result = Arrays.asList(objects).parallelStream().mapToDouble((o) -> o.getMeasure()).average();
            return result.getAsDouble();
        }
    }
}

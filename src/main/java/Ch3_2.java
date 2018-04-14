import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class Ch3_2 {
    interface Measurable {
        double getMeasure();
    }

    static class Employee implements Measurable {
        private final double salary;
        private final String name;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public double getMeasure() {
            return this.salary;
        }

        public String getName() {
            return name;
        }

        static double average(Measurable[] objects) {
            var result = Arrays.asList(objects).parallelStream().mapToDouble((o) -> o.getMeasure()).average();
            return result.getAsDouble();
        }

        static Measurable largest(Measurable[] objects) {
            return Arrays.asList(objects).parallelStream().max(Comparator.comparingDouble(d -> d.getMeasure())).get();
        }
    }
}

import java.util.Comparator;

public class Ch3_15 {
    Comparator<Employee> cmp = ((Comparator<Employee>) Comparator.comparing(Employee::getSalary))
            .thenComparing(Comparator.comparing(Employee::getName));
    Comparator<Employee> reversedCmp = ((Comparator<Employee>) Comparator.comparing(Employee::getSalary).reversed())
            .thenComparing(Comparator.comparing(Employee::getName));


    class Employee {
        private final String name;
        private final Double salary;

        public Employee(String name, Double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Double getSalary() {
            return salary;
        }
    }
}

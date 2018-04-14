import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_15_Test {
    @Test
    public void testEmployeeReversedComparator() {
        var app = new Ch3_15();
        var employees = new Ch3_15.Employee[5];
        employees[0] = app.new Employee("joe", 50.0);
        employees[1] = app.new Employee("sam", 30.0);
        employees[2] = app.new Employee("jane", 50.0);
        employees[3] = app.new Employee("mary", 60.0);
        employees[4] = app.new Employee("tom", 40.0);

        Arrays.sort(employees, app.reversedCmp);
        assertEquals("mary", employees[0].getName());
        assertEquals("jane", employees[1].getName());
        assertEquals("joe", employees[2].getName());
        assertEquals("tom", employees[3].getName());
        assertEquals("sam", employees[4].getName());
    }

    @Test
    public void testEmployeeComparator() {
        var app = new Ch3_15();
        var employees = new Ch3_15.Employee[5];
        employees[0] = app.new Employee("joe", 50.0);
        employees[1] = app.new Employee("sam", 30.0);
        employees[2] = app.new Employee("jane", 50.0);
        employees[3] = app.new Employee("mary", 60.0);
        employees[4] = app.new Employee("tom", 40.0);

        Arrays.sort(employees, app.cmp);
        assertEquals("mary", employees[4].getName());
        assertEquals("jane", employees[2].getName());
        assertEquals("joe", employees[3].getName());
        assertEquals("tom", employees[1].getName());
        assertEquals("sam", employees[0].getName());
    }
}

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_2_Test {
    @ParameterizedTest
    @CsvSource({"'joe:0.0,jane:20.0','jane'",
            "'fred:10.0,frank:20.0,fink:30.0','fink'",
            "'julio:4.0,bill:1.0,bob:1.0,jane:1.0,joe:3.0,fred:3.0,james:3.0','julio'"})
    public void testEmployeeLargestSalaryName(String data, String expectedLargest) {
        var input = Arrays.stream(data.split(","))
                .map((s) -> new Ch3_2.Employee(s.split(":")[0], Double.parseDouble(s.split(":")[1])))
                .toArray(Ch3_2.Measurable[]::new);
        assertEquals(expectedLargest, ((Ch3_2.Employee) Ch3_2.Employee.largest(input)).getName());
    }

    @ParameterizedTest
    @CsvSource({"'joe:0.0,jane:20.0',10.0",
            "'fred:10.0,frank:20.0,fink:30.0',20.0",
            "'julio:4.0,bill:1.0,bob:1.0,jane:1.0,joe:3.0,fred:3.0,james:3.0',2.285"})
    public void testEmployeeAverageSalary(String data, double expectedAverage) {
        var input = Arrays.stream(data.split(","))
                .map((s) -> new Ch3_2.Employee(s.split(":")[0], Double.parseDouble(s.split(":")[1])))
                .toArray(Ch3_2.Measurable[]::new);
        assertEquals(expectedAverage, Ch3_2.Employee.average(input), 0.001);
    }

}

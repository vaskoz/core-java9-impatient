import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_1_Test {
    @ParameterizedTest
    @CsvSource({"'0.0,20.0', 10.0,",
            "'10.0,20.0,30.0', 20.0",
            "'1.0,1.0,1.0,3.0,3.0,3.0', 2.0"})
    public void testEmployeeAverageSalary(String data, double average) {
        var input = Arrays.stream(data.split(","))
                .map(s -> new Ch3_1.Employee(Double.parseDouble(s)))
                .toArray(Ch3_1.Measurable[]::new);
        assertEquals(average, Ch3_1.Employee.average(input), 0.0001);
    }
}

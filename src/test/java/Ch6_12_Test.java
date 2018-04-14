import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch6_12_Test {
    @Test
    public void testMinMax() {
        var elements = new ArrayList<>(Arrays.asList(5.3, 2.4, 9.5, 10.1, 1.2, 6.9));
        var result = new ArrayList<Double>(2);
        Ch6_12.minmax(elements, Double::compareTo, result);
        assertEquals(Double.valueOf(1.2), result.get(0));
        assertEquals(Double.valueOf(10.1), result.get(1));
    }
}

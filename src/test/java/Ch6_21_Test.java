import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch6_21_Test {
    @Test
    public void testConstruct() {
        List<String>[] result = Ch6_21.Arrays.construct(10);
        assertEquals(10, result.length);
        assertTrue(result instanceof List[]);

        Integer[] result2 = Ch6_21.Arrays.construct(20);
        assertEquals(20, result2.length);
        assertTrue(result2 instanceof Integer[]);
    }
}

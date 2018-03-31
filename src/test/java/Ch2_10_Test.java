import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch2_10_Test {
    @Test
    public void testRandomElementArray() {
        var input = new int[]{1, 2, 1, 2, 1, 1, 2, 2};
        var result = Ch2_10.RandomNumbers.randomElement(input);
        assertTrue(result == 1 || result == 2);
        assertEquals(0, Ch2_10.RandomNumbers.randomElement(new int[]{}));
    }

    @Test
    public void testRandomElementList() {
        var input = List.of(1, 2, 1, 2, 1, 1, 2, 2);
        var result = Ch2_10.RandomNumbers.randomElement(input);
        assertTrue(result == 1 || result == 2);
        assertEquals(0, Ch2_10.RandomNumbers.randomElement(List.of()));
    }
}

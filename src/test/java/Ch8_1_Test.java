import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Ch8_1_Test {
    @Test
    public void stopFilter() {
        var input = List.of("d", "c", "b", "a", "abc", "a", "ba", "ddd", "fedcba");
        var expected = List.of("abc");
        assertEquals(expected, Ch8_1.filterLongStrings(input, 2, 1));
    }

    @Test
    public void filterString() {
        var input = List.of("abc", "a", "ba", "ddd");
        var expected = List.of("abc", "ddd");
        assertEquals(expected, Ch8_1.filterLongStrings(input, 2, 5));
        assertEquals(expected, Ch8_1.filterLongStrings(input, 2, 2));
        assertNotEquals(expected, Ch8_1.filterLongStrings(input, 2, 1));
    }
}

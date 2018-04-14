import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch7_13_Test {
    private final List<String> strings = List.of("a", "b", "c", "d", "e", "f");
    private final List<Integer> ints = List.of(1, 2, 3, 4, 5, 6);
    private final Map<String, Integer> expected = Map.of("b", 2, "c", 3, "d", 4, "e", 5, "f", 6);

    @Test
    public void testCache() {
        assertEquals(this.strings.size(), this.ints.size());
        var cache = new Ch7_13.Cache<String, Integer>(5);
        for (var i = 0; i < this.strings.size(); i++) {
            cache.put(strings.get(i), ints.get(i));
        }
        assertEquals(this.expected.entrySet(), cache.entrySet());
    }
}

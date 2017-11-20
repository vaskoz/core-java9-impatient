import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch7_7_Test {
    private List<String> words = List.of("hi", "there", "hi", "there", "hi", "old", "buddy");
    private Map<String, Integer> expected = Map.of("hi", 3, "there", 2, "old", 1, "buddy", 1);

    @Test
    public void testCountOccurrences() {
        assertEquals(this.expected, Ch7_7.countOccurrence(this.words));
    }
}

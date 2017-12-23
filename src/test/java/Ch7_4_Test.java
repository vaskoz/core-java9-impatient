import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch7_4_Test {
    private static List<String> expected = List.of("a", "b");
    private List<String> input = new ArrayList<>(Arrays.asList("a", "b", "c"));
    private String target = "c";

    @Test
    public void testRemoveTargetFor() {
        Ch7_4.removeTargetFor(this.input, "doesn't exist");
        assertThrows(ConcurrentModificationException.class, () -> Ch7_4.removeTargetFor(this.input, this.target));
    }

    @Test
    public void testRemoveTargetIterator() {
        Ch7_4.removeTargetIterator(this.input, this.target);
        assertEquals(expected, this.input);
    }

    @Test
    public void testRemoveTargetCollection() {
        Ch7_4.removeTargetCollection(this.input, this.target);
        assertEquals(expected, this.input);
    }

    @Test
    public void testRemoveTargetIf() {
        Ch7_4.removeTargetIf(this.input, this.target);
        assertEquals(expected, this.input);
    }
}

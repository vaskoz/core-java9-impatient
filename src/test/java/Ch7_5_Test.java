import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch7_5_Test {
    private static List<String> expected = List.of("a", "b", "c", "d", "e");
    private List<String> input = Arrays.asList("a", "e", "c", "d", "b");
    private int i = 1, j = 4;

    @Test
    public void testRandomAccessSwap() {
        this.input = new ArrayList<>(this.input);
        Ch7_5.swap(this.input, i, j);
        assertEquals(expected, this.input);
    }

    @Test
    public void testSequentialAccessSwap() {
        this.input = new LinkedList<>(this.input);
        Ch7_5.swap(this.input, i, j);
        assertEquals(expected, this.input);
    }

    @Test
    public void outOfRangeSwap() {
        assertThrows(IllegalArgumentException.class,
                () -> Ch7_5.swap(new ArrayList<>(this.input), 0, this.input.size()));
        assertThrows(IllegalArgumentException.class,
                () -> Ch7_5.swap(new LinkedList<>(this.input), 0, this.input.size()));
    }
}

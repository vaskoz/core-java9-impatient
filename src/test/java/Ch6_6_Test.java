import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch6_6_Test {

    @Test
    public void testAppend() {
        var expected = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        var dest = new ArrayList<>(Arrays.asList("a", "b", "c"));
        var src = new ArrayList<>(Arrays.asList("d", "e", "f"));
        Ch6_6.append(dest, src);
        assertEquals(expected, dest);
    }

    @Test
    public void testAppend2() {
        var expected = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        var dest = new ArrayList<>(Arrays.asList("a", "b", "c"));
        var src = new ArrayList<>(Arrays.asList("d", "e", "f"));
        Ch6_6.append2(dest, src);
        assertEquals(expected, dest);
    }
}

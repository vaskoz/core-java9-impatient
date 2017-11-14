import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch6_6_Test {

    @Test
    public void testAppend() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        ArrayList<String> dest = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> src = new ArrayList<>(Arrays.asList("d", "e", "f"));
        Ch6_6.append(dest, src);
        assertEquals(expected, dest);
    }

    @Test
    public void testAppend2() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        ArrayList<String> dest = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> src = new ArrayList<>(Arrays.asList("d", "e", "f"));
        Ch6_6.append2(dest, src);
        assertEquals(expected, dest);
    }
}

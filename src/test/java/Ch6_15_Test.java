import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch6_15_Test {
    @Test
    public void testMap() {
        Function<Integer, String> alphaPosition = t -> String.valueOf((char) ('a' + (t % 26)));
        assertEquals(List.of("z", "c", "a", "b"), Ch6_15.map(List.of(25, 2, 0, 1), alphaPosition));
        assertEquals(List.of("a", "b", "c", "a"), Ch6_15.map(List.of(0, 1, 2, 0), alphaPosition));

        Function<Integer, Boolean> isEven = t -> t % 2 == 0;
        assertEquals(List.of(true, true, true, true, false), Ch6_15.map(List.of(100, 200, 8, 4, 101), isEven));
        assertEquals(List.of(false, false, false), Ch6_15.map(List.of(1, 3, 5), isEven));
    }
}

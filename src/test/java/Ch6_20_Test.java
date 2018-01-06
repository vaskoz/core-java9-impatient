import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Ch6_20_Test {
    @Test
    public void genericRepeat() {
        assertArrayEquals(List.of(1, 2, 3, 1, 2, 3, 1, 2, 3).toArray(), Ch6_20.repeat(3, 1, 2, 3));
        assertArrayEquals(List.of("a", "b", "a", "b").toArray(), Ch6_20.repeat(2, "a", "b"));
    }
}

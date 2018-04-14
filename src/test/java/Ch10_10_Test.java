import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch10_10_Test {
    @Test
    public void longAccumulatorMinimum() {
        var minimum = new LongAccumulator((left, right) ->
                left < right ? left : right, 0L);
        for (var i : List.of(10, 3, 20, 100, -2)) {
            minimum.accumulate(i);
        }
        assertEquals(-2, minimum.get());
    }

    @Test
    public void longAccumulatorMaximum() {
        var maximum = new LongAccumulator((left, right) ->
                left > right ? left : right, 0L);
        for (var i : List.of(10, 3, 20, 100, -2)) {
            maximum.accumulate(i);
        }
        assertEquals(100, maximum.get());
    }
}

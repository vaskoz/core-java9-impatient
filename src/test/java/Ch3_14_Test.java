import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_14_Test {
    @Test
    public void testRunInOrder() {
        var result = new boolean[5];
        var list = new Runnable[]{
                () -> result[0] = true,
                () -> result[1] = result[0] && (result[1] = true),
                () -> result[2] = result[1] && (result[2] = true),
                () -> result[3] = result[2] && (result[3] = true),
                () -> result[4] = result[3] && (result[4] = true)
        };
        var orderedRun = Ch3_14.inOrder(list);
        orderedRun.run();
        for (var b : result) {
            assertTrue(b);
        }
    }
}

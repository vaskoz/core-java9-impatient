import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_10_Test {
    @Test
    public void testRunTogether() throws InterruptedException {
        var ai = new AtomicInteger(0);
        Ch3_10.runTogether(
                () -> ai.addAndGet(2),
                () -> ai.addAndGet(3),
                () -> ai.addAndGet(-2),
                () -> ai.addAndGet(-3)
        );
        assertEquals(0, ai.get());
    }

    @Test
    public void testRunInOrder() {
        var ai = new AtomicInteger(0);
        Ch3_10.runInOrder(
                () -> ai.addAndGet(2),
                () -> ai.addAndGet(3),
                () -> ai.addAndGet(-2),
                () -> ai.addAndGet(-3)
        );
    }
}

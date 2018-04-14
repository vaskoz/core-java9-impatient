import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch5_9_Test {
    @Test
    public void testLock() {
        var lock = Ch5_9.lock();
        try (lock) {
            assertTrue(lock.isLocked());
        } finally {
            assertFalse(lock.isLocked());
        }
    }
}

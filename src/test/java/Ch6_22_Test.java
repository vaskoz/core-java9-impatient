import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch6_22_Test {
    @Test
    public void testDoWork() {
        class MyPersonalException extends Exception {
        }
        assertThrows(MyPersonalException.class, () -> Ch6_22.doWork(() -> {
            throw new MyPersonalException();
        }));
    }
}

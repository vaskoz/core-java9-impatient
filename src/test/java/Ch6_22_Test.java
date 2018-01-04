import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch6_22_Test {
    @Test
    public void testDoWork() {
        class MyPersonalException extends Exception {
            public MyPersonalException(Throwable cause) {
                super(cause);
            }
        }
        assertThrows(MyPersonalException.class, () -> Ch6_22.doWork(() -> {
            throw new MyPersonalException(null);
        }, MyPersonalException::new));
    }
}

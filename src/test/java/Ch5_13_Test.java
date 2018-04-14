import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch5_13_Test {
    @Test
    public void testMin() {
        var values = new int[]{8, 3, 10, 3443, -244, 1000, 2000, 4000};
        assertEquals(-244, Ch5_13.min(values));
    }
}

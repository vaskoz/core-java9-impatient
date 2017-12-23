import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch12_6_Test {
    @Test
    public void testFriday13ths() {
        assertEquals(171, Ch12_6.numberOfFriday13thInCentury(20));
        assertEquals(173, Ch12_6.numberOfFriday13thInCentury(19));
        assertEquals(172, Ch12_6.numberOfFriday13thInCentury(21));
        assertThrows(IllegalArgumentException.class, () -> Ch12_6.numberOfFriday13thInCentury(0));
    }
}

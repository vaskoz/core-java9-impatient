import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch13_2_Test {
    @Test
    public void findNonWesternDigits() {
        var locales = Ch13_2.noWesternDigits();
        assertEquals(2, locales.length);
    }
}

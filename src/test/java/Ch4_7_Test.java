import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch4_7_Test {
    @Test
    public void testGetGreen() {
        var pc = Ch4_7.PrimaryColors.getGreen();
        assertEquals(Ch4_7.PrimaryColors.GREEN, pc);
    }

    @Test
    public void testGetBlue() {
        var pc = Ch4_7.PrimaryColors.getBlue();
        assertEquals(Ch4_7.PrimaryColors.BLUE, pc);
    }

    @Test
    public void testGetRed() {
        var pc = Ch4_7.PrimaryColors.getRed();
        assertEquals(Ch4_7.PrimaryColors.RED, pc);
    }
}

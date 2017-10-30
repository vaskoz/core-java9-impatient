import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch4_7_Test {
    @Test
    public void testGetGreen() {
        Ch4_7.PrimaryColors pc = Ch4_7.PrimaryColors.getGreen();
        assertEquals(Ch4_7.PrimaryColors.GREEN, pc);
    }

    @Test
    public void testGetBlue() {
        Ch4_7.PrimaryColors pc = Ch4_7.PrimaryColors.getBlue();
        assertEquals(Ch4_7.PrimaryColors.BLUE, pc);
    }

    @Test
    public void testGetRed() {
        Ch4_7.PrimaryColors pc = Ch4_7.PrimaryColors.getRed();
        assertEquals(Ch4_7.PrimaryColors.RED, pc);
    }
}

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch12_5_Test {
    @Test
    public void daysAlive() {
        assertEquals(366, Ch12_5.daysAlive(LocalDate.of(1980, 1, 1),
                LocalDate.of(1981, 1, 1)));
        assertEquals(731, Ch12_5.daysAlive(LocalDate.of(1980, 1, 1),
                LocalDate.of(1982, 1, 1)));
        assertEquals(1, Ch12_5.daysAlive(LocalDate.of(2017, 12, 14),
                LocalDate.of(2017, 12, 15)));
    }
}

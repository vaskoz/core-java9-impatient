import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch12_2_Test {
    private final LocalDate start = LocalDate.of(2000, 2, 29);

    @Test
    public void addOneYear() {
        assertEquals(LocalDate.of(2001, 2, 28), this.start.plusYears(1));
    }

    @Test
    public void addFourYears() {
        assertEquals(LocalDate.of(2004, 2, 29), this.start.plusYears(4));
    }

    @Test
    public void addYearFourTimes() {
        assertEquals(LocalDate.of(2004, 2, 28),
                this.start.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
    }
}

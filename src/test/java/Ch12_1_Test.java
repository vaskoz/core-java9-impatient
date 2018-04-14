import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch12_1_Test {
    private static List<LocalDate> programmerDates = new ArrayList<>();

    @BeforeAll
    public static void setupProgrammerDates() {
        programmerDates.add(LocalDate.of(900, 9, 13));
        programmerDates.add(LocalDate.of(2017, 9, 13));
        programmerDates.add(LocalDate.of(2018, 9, 13));
        programmerDates.add(LocalDate.of(2020, 9, 12));
    }

    @Test
    public void originalPlusDays() {
        for (var ld : programmerDates) {
            var pd = Ch12_1.plusDaysVersion(ld.getYear());
            assertEquals(ld, pd);
        }
    }

    @Test
    public void newVersion() {
        for (var ld : programmerDates) {
            var pd = Ch12_1.newVersion(ld.getYear());
            assertEquals(ld, pd);
        }
    }

    @Test
    public void useConstants() {
        for (var ld : programmerDates) {
            var pd = Ch12_1.useConstant(ld.getYear());
            assertEquals(ld, pd);
        }
    }

    @AfterAll
    public static void cleanup() {
        programmerDates.clear();
        programmerDates = null;
    }
}

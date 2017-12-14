import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Ch12_5 {
    public static long daysAlive(LocalDate birthday, LocalDate now) {
        return DAYS.between(birthday, now);
    }
}

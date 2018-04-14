import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ch12_6 {
    public static int numberOfFriday13thInCentury(int century) {
        if (century < 1) {
            throw new IllegalArgumentException("Century must be greater than 1");
        }
        var start = LocalDate.of(-99, 1, 1)
                .plus(century, ChronoUnit.CENTURIES);
        var end = start.plus(1, ChronoUnit.CENTURIES);
        var friday13thDays = 0;
        for (var current = start; current.isBefore(end); current = current.plusMonths(1)) {
            if (current.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                friday13thDays++;
            }
        }
        return friday13thDays;
    }
}

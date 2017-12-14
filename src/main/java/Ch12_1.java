import java.time.LocalDate;

public class Ch12_1 {
    private static final LocalDate usual = LocalDate.of(1, 9, 13);
    private static final LocalDate leap = LocalDate.of(1, 9, 12);


    public static LocalDate plusDaysVersion(int year) {
        return LocalDate.of(year, 1, 1).plusDays(255);
    }

    public static LocalDate newVersion(int year) {
        return LocalDate.of(year, 1, 1).withDayOfYear(256);
    }

    public static LocalDate useConstant(int year) {
        return LocalDate.of(year, 1, 1).isLeapYear() ?
                leap.withYear(year) :
                usual.withYear(year);
    }
}

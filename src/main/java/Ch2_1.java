import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Works like Unix command <pre>cal</pre> for today.
 */
public class Ch2_1 {
    public static void main(String[] args) {
        var today = LocalDate.now();
        // Print calendar header of month & year
        System.out.println(today.getMonth().toString() + " " + today.getYear());
        var date = LocalDate.of(today.getYear(), today.getMonth(), 1);
        var order = buildDayAbbrev();
        // print the abbreviations for days of the week starting from Sunday.
        for (var abbrev : order.values()) {
            System.out.printf("%s\t", abbrev);
        }
        System.out.println();
        // Adjust printing position to accommodate Sunday start
        var pos = date.getDayOfWeek().getValue() == 7 ? 0 : date.getDayOfWeek().getValue();
        for (var i = 0; i < pos; i++) {
            System.out.print(" \t");
        }
        while (date.getMonthValue() == today.getMonthValue()) {
            var format = pos++ % 7 == 6 ? "%d\n" : "%d\t";
            System.out.printf(format, date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    private static Map<DayOfWeek, String> buildDayAbbrev() {
        var result = new LinkedHashMap<DayOfWeek, String>(7);
        result.put(DayOfWeek.SUNDAY, "Su");
        result.put(DayOfWeek.MONDAY, "Mo");
        result.put(DayOfWeek.TUESDAY, "Tu");
        result.put(DayOfWeek.WEDNESDAY, "We");
        result.put(DayOfWeek.THURSDAY, "Th");
        result.put(DayOfWeek.FRIDAY, "Fr");
        result.put(DayOfWeek.SATURDAY, "Sa");
        return result;
    }
}

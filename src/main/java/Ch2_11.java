import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.out;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;

/**
 * Works like Unix command <pre>cal</pre> for today.
 */
public class Ch2_11 {
    public static void main(String[] args) {
        var today = now();
        // Print calendar header of month & year
        out.println(today.getMonth().toString() + " " + today.getYear());
        var date = of(today.getYear(), today.getMonth(), 1);
        var order = buildDayAbbrev();
        // print the abbreviations for days of the week starting from Sunday.
        for (var abbrev : order.values()) {
            out.printf("%s\t", abbrev);
        }
        out.println();
        // Adjust printing position to accommodate Sunday start
        var pos = date.getDayOfWeek().getValue() == 7 ? 0 : date.getDayOfWeek().getValue();
        for (var i = 0; i < pos; i++) {
            out.print(" \t");
        }
        while (date.getMonthValue() == today.getMonthValue()) {
            var format = pos++ % 7 == 6 ? "%d\n" : "%d\t";
            out.printf(format, date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    private static Map<DayOfWeek, String> buildDayAbbrev() {
        var result = new LinkedHashMap<DayOfWeek, String>(7);
        result.put(SUNDAY, "Su");
        result.put(MONDAY, "Mo");
        result.put(TUESDAY, "Tu");
        result.put(WEDNESDAY, "We");
        result.put(THURSDAY, "Th");
        result.put(FRIDAY, "Fr");
        result.put(SATURDAY, "Sa");
        return result;
    }
}

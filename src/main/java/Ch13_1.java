import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Ch13_1 {
    static String getFranceDateTime(TemporalAccessor temporalAccessor) {
        return DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.FRANCE)
                .format(temporalAccessor);
    }

    static String getChinaDateTime(TemporalAccessor temporalAccessor) {
        return DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.CHINA)
                .format(temporalAccessor);
    }

    static String getThailandDateTime(TemporalAccessor temporalAccessor) {
        return DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("th", "TH", "TH"))
                .format(temporalAccessor);
    }
}

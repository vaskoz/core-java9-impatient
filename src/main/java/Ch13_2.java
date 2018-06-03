import java.util.ArrayList;
import java.util.Locale;

public class Ch13_2 {
    public static Locale[] noWesternDigits() {
        var results = new ArrayList<Locale>();
        for (Locale locale : Locale.getAvailableLocales()) {
            if (null != locale.getExtension(Locale.UNICODE_LOCALE_EXTENSION)) {
                results.add(locale);
            }
        }
        return results.toArray(new Locale[]{});
    }
}

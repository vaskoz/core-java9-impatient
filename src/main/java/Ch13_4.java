import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Ch13_4 {
    public static Set<String> getAllLanguages() {
        var result = new HashSet<String>();
        for (var locale : Locale.getAvailableLocales()) {
            for (var inLocale : Locale.getAvailableLocales()) {
                var displayLanguage = locale.getDisplayLanguage(inLocale);
                if (!displayLanguage.isEmpty()) {
                    result.add(displayLanguage);
                }
            }
        }
        return result;
    }
}

import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Ch13_5 {
    public static Set<String> getAllCurrencies() {
        var results = new HashSet<String>();
        for (var currency : Currency.getAvailableCurrencies()) {
            for (var locale : Locale.getAvailableLocales()) {
                results.add(currency.getDisplayName(locale));
            }
        }
        return results;
    }
}

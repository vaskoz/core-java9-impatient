import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ch7_7 {
    public static Map<String, Integer> countOccurrence(List<String> words) {
        var occurrences = new TreeMap<String, Integer>();
        for (var word : words) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }
        return occurrences;
    }
}

import java.util.List;
import java.util.stream.Collectors;

public class Ch8_1 {
    public static List<String> filterLongStrings(List<String> input, int length, int limit) {
        return input.stream().filter(s -> s.length() > length)
                .limit(limit).collect(Collectors.toList());
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ch3_8 {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }

    static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
        for (var i = 0; i < strings.size() - 1; i++) {
            if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}

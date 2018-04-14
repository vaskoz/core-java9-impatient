import java.util.ArrayList;
import java.util.ListIterator;

public class Ch7_2 {
    public static ArrayList<String> toUpperCaseA(ArrayList<String> strings) {
        for (var iter = strings.listIterator(); iter.hasNext(); ) {
            String next = iter.next();
            String upper = next.toUpperCase();
            iter.set(upper);
        }
        return strings;
    }

    public static ArrayList<String> toUpperCaseB(ArrayList<String> strings) {
        for (var i = 0; i < strings.size(); i++) {
            var next = strings.get(i);
            var upper = next.toUpperCase();
            strings.set(i, upper);
        }
        return strings;
    }

    public static ArrayList<String> toUpperCaseC(ArrayList<String> strings) {
        strings.replaceAll(s -> s.toUpperCase());
        return strings;
    }

}

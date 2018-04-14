import java.util.HashSet;
import java.util.Set;

public class Ch7_3 {
    public static <E> Set<E> union(Set<E> first, Set<E> second) {
        var result = new HashSet<E>(first.size() + second.size());
        result.addAll(first);
        result.addAll(second);
        return result;
    }

    public static <E> Set<E> intersection(Set<E> first, Set<E> second) {
        var result = new HashSet<E>(first.size() + second.size());
        result.addAll(first);
        result.retainAll(second);
        return result;
    }

    public static <E> Set<E> difference(Set<E> first, Set<E> second) {
        var result = new HashSet<E>(first.size() + second.size());
        result.addAll(first);
        result.removeAll(second);
        return result;
    }
}

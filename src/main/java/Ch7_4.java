import java.util.List;
import java.util.ListIterator;

public class Ch7_4 {
    public static <E> void removeTargetFor(List<E> list, E target) {
        for (E e : list) {
            if (e.equals(target)) {
                list.remove(e); // throws ConcurrentModificationException
            }
        }
    }

    public static <E> void removeTargetIterator(List<E> list, E target) {
        for (var iterator = list.listIterator(); iterator.hasNext(); ) {
            E e = iterator.next();
            if (e.equals(target)) {
                iterator.remove();
            }
        }
    }

    public static <E> void removeTargetCollection(List<E> list, E target) {
        list.remove(target);
    }

    public static <E> void removeTargetIf(List<E> list, E target) {
        list.removeIf(e -> e.equals(target));
    }
}

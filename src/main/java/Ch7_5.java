import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Ch7_5 {
    public static void swap(List<?> list, int i, int j) {
        if (i >= list.size() || j >= list.size()) {
            throw new IllegalArgumentException("out of range");
        }
        if (list instanceof RandomAccess) {
            randomAccessSwap(list, i, j);
        } else {
            sequentialAccessSwap(list, i, j);
        }
    }

    /**
     * Conserve sequential traversal by using a single iterator
     */
    private static <E> void sequentialAccessSwap(List<E> list, int i, int j) {
        ListIterator<E> iter = list.listIterator(i);
        E first = iter.next();
        for (int x = i + 1; x < j; x++) {
            iter.next();
        }
        E second = iter.next();
        iter.set(first);
        for (int x = j; x >= i; x--) {
            iter.previous();
        }
        iter.set(second);
    }

    private static <E> void randomAccessSwap(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}

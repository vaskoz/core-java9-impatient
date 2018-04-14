import java.util.ArrayList;
import java.util.Collections;

public class Ch6_11 {
    // Question 6.7
    static class Pair<E extends Comparable<E>> {
        private E first, second;

        public void setFirst(E first) {
            this.first = first;
        }

        public void setSecond(E second) {
            this.second = second;
        }

        // Question 6.8
        public E max() {
            return this.first.compareTo(this.second) > 0 ? this.first : this.second;
        }

        public E min() {
            return this.first.compareTo(this.second) <= 0 ? this.first : this.second;
        }
    }

    // Question 6.9
    static class Arrays {
        public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<? extends E> a) {
            var p = new Pair<E>();
            p.setFirst(a.get(0));
            p.setSecond(a.get(a.size() - 1));
            return p;
        }

        // Question 6.10
        public static <E extends Comparable<E>> E min(ArrayList<E> a) {
            return Collections.min(a);
        }

        public static <E extends Comparable<E>> E max(ArrayList<E> a) {
            return Collections.max(a);
        }

        // Question 6.11
        public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<E> a) {
            var p = new Pair<E>();
            p.setFirst(min(a));
            p.setSecond(max(a));
            return p;
        }
    }
}

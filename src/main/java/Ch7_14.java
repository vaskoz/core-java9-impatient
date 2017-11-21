import java.util.Iterator;

public class Ch7_14 {
    public static Iterator<Integer> immutableListView(int n) {
        return new Iterator<Integer>() {
            private int current;

            @Override
            public boolean hasNext() {
                return this.current < n;
            }

            @Override
            public Integer next() {
                return this.current++;
            }
        };
    }
}

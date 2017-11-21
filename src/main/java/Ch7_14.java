import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ch7_14 {
    public static Iterator<Integer> immutableListView(int n) {
        return new Iterator<Integer>() {
            private int current;

            @Override
            public boolean hasNext() {
                return this.current <= n;
            }

            @Override
            public Integer next() {
                if (this.current > n) {
                    throw new NoSuchElementException("went too far");
                }
                return this.current++;
            }
        };
    }
}

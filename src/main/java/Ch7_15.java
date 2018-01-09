import java.util.Iterator;
import java.util.function.IntFunction;

public class Ch7_15 {
    public static Iterator<Integer> immutableListView(IntFunction<Integer> intFunction) {
        return new Iterator<Integer>() {
            private int current = 0;
            private IntFunction<Integer> func = intFunction;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                this.current = this.func.apply(this.current);
                return this.current;
            }
        };
    }
}

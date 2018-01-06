import java.util.ArrayList;
import java.util.List;

public class Ch6_21 {
    public static class Arrays {
        @SafeVarargs
        public static <T> T[] construct(int size, T... emptyValue) {
            List<T> x = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                x.add(null);
            }
            return x.toArray(emptyValue);
        }
    }
}

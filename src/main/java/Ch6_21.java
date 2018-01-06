import java.util.ArrayList;
import java.util.Collections;

public class Ch6_21 {
    public static class Arrays {
        @SafeVarargs
        public static <T> T[] construct(int size, T... emptyValue) {
            return new ArrayList<>(Collections.nCopies(size, null)).toArray(emptyValue);
        }
    }
}

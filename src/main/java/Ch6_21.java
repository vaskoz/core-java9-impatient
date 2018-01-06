import java.util.Collections;

public class Ch6_21 {
    public static class Arrays {
        @SafeVarargs
        public static <T> T[] construct(int size, T... emptyValue) {
            return Collections.nCopies(size, null).toArray(emptyValue);
        }
    }
}

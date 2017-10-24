import java.math.BigInteger;

public class Ch3_6 {
    interface Sequence<T> {
        default boolean hasNext() { return true; }
        T next();
    }

    static class SquareSequence implements Sequence<BigInteger> {
        private Integer value = 1;

        @Override
        public BigInteger next() {
            BigInteger v = new BigInteger(value.toString());
            value++;
            return v.multiply(v);
        }
    }
}

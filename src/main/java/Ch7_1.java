import java.util.*;

public class Ch7_1 {
    public static List<Integer> sieveOfErathostenes(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("value of n must be greater than 2");
        }
        Set<Integer> numbers = new HashSet<>(n);
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }
        for (int i = 2; i <= Math.sqrt((double) n); i++) {
            if (numbers.contains(i)) {
                for (int j = i * i; j <= n; j += i) {
                    numbers.remove(j);
                }
            }
        }
        return new ArrayList<>(numbers);
    }

    public static List<Integer> sieveOfErathostenesBitSet(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("value of n must be greater than 2");
        }
        BitSet numbers = new BitSet(n);
        for (int i = 2; i <= n; i++) {
            numbers.set(i);
        }
        for (int i = 2; i <= Math.sqrt((double) n); i++) {
            if (numbers.get(i)) {
                for (int j = i * i; j <= n; j += i) {
                    numbers.clear(j);
                }
            }
        }
        List<Integer> result = new ArrayList<>(numbers.cardinality());
        for (int i = numbers.nextSetBit(0); i >= 0; i = numbers.nextSetBit(i+1)) {
            result.add(i);
            if (i == Integer.MAX_VALUE) {
                break; // or (i+1) would overflow
            }
        }
        return result;
    }
}

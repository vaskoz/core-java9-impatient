import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ch7_1 {
    public static List<Integer> sieveOfErathostenes(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("value of n must be greater than 2");
        }
        var numbers = new HashSet<Integer>(n);
        for (var i = 2; i <= n && i >= 2; i++) {
            numbers.add(i);
        }
        for (var i = 2; i <= Math.sqrt((double) n); i++) {
            if (numbers.contains(i)) {
                for (var j = i * i; j <= n && j > 0; j += i) {
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
        var numbers = new BitSet(n);
        for (var i = 2; i <= n && i >= 2; i++) {
            numbers.set(i);
        }
        for (var i = 2; i <= Math.sqrt((double) n); i++) {
            if (numbers.get(i)) {
                for (var j = i * i; j <= n && j >= 0; j += i) {
                    numbers.clear(j);
                }
            }
        }
        var result = new ArrayList<Integer>(numbers.cardinality());
        var i = numbers.nextSetBit(0);
        while (i + 1 > 0) {
            result.add(i);
            i = numbers.nextSetBit(i + 1);
        }
        return result;
    }
}

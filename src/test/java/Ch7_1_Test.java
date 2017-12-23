import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch7_1_Test {
    private static List<Integer> primes;

    @BeforeAll
    public static void setupPrimes() {
        primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
                103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167,
                173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
                241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
                317, 331, 337, 347, 349);
    }

    @Test
    public void testSieveOfErathostenes() {
        assertEquals(primes.subList(0, 1), Ch7_1.sieveOfErathostenes(2));
        assertEquals(primes.subList(0, 5), Ch7_1.sieveOfErathostenes(12));
        assertEquals(primes.subList(0, 9), Ch7_1.sieveOfErathostenes(25));
        assertEquals(primes.subList(0, 25), Ch7_1.sieveOfErathostenes(100));
        assertEquals(primes, Ch7_1.sieveOfErathostenes(350));

        assertThrows(IllegalArgumentException.class, () -> {
            Ch7_1.sieveOfErathostenes(1);
        });
    }

    @Test
    public void testSieveOfErathostenesBitSet() {
        assertEquals(primes.subList(0, 1), Ch7_1.sieveOfErathostenesBitSet(2));
        assertEquals(primes.subList(0, 5), Ch7_1.sieveOfErathostenesBitSet(12));
        assertEquals(primes.subList(0, 9), Ch7_1.sieveOfErathostenesBitSet(25));
        assertEquals(primes.subList(0, 25), Ch7_1.sieveOfErathostenesBitSet(100));
        assertEquals(primes, Ch7_1.sieveOfErathostenesBitSet(350));

        assertThrows(IllegalArgumentException.class, () -> {
            Ch7_1.sieveOfErathostenesBitSet(1);
        });
    }
}

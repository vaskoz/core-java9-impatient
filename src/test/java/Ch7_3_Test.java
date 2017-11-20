import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch7_3_Test {
    private static Set<String> intersectExpected, diffExpected, unionExpected, first, second;

    @BeforeAll
    public static void setupData() {
        first = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("one", "three", "four", "five")));
        second = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("two", "three", "five", "six")));
        unionExpected = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("one", "two", "three", "four", "five", "six")));
        diffExpected = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("one", "four")));
        intersectExpected = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("three", "five")));
    }

    @Test
    public void testUnion() {
        assertEquals(unionExpected, Ch7_3.union(first, second));
    }

    @Test
    public void testDifference() {
        assertEquals(diffExpected, Ch7_3.difference(first, second));
    }

    @Test
    public void testIntersect() {
        assertEquals(intersectExpected, Ch7_3.intersection(first, second));
    }
}

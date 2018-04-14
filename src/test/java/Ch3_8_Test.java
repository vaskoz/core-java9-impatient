import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_8_Test {
    @Test
    public void testLuckySort() {
        var cmp = Comparator.<String>naturalOrder();
        var data = new ArrayList<>(Arrays.asList("bird", "ant", "door", "cat", "zebra", "everything"));
        Ch3_8.luckySort(data, cmp);
        assertTrue(Ch3_8.isSorted(data, cmp));
    }

    @Test
    public void testIsSorted() {
        var cmp = Comparator.<String>naturalOrder();
        var notSorted = new ArrayList<>(Arrays.asList("bird", "ant", "door", "cat", "zebra", "everything"));
        assertFalse(Ch3_8.isSorted(notSorted, cmp));

        notSorted.sort(cmp);
        assertTrue(Ch3_8.isSorted(notSorted, cmp));
    }
}

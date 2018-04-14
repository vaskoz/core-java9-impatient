import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch6_11_Test {
    @Test
    public void testPairMinMax() {
        var pair = new Ch6_11.Pair<Double>();
        pair.setFirst(4.5);
        pair.setSecond(3.5);
        assertEquals(Double.valueOf(3.5), pair.min());
        assertEquals(Double.valueOf(4.5), pair.max());
    }

    @Test
    public void testArraysFirstLast() {
        var ad = new ArrayList<>(Arrays.asList(4.5, 6.3, 2.7, 9.1));
        var pd = Ch6_11.Arrays.firstLast(ad);
        assertEquals(Double.valueOf(4.5), pd.min());
        assertEquals(Double.valueOf(9.1), pd.max());
    }

    @Test
    public void testArraysMinAndMax() {
        var ad = new ArrayList<>(Arrays.asList(4.5, 6.3, 2.7, 9.1));
        assertEquals(Double.valueOf(2.7), Ch6_11.Arrays.min(ad));
        assertEquals(Double.valueOf(9.1), Ch6_11.Arrays.max(ad));
    }

    @Test
    public void testArraysMinMax() {
        var ad = new ArrayList<>(Arrays.asList(4.5, 6.3, 2.7, 9.1));
        var pd = Ch6_11.Arrays.minMax(ad);
        assertEquals(Double.valueOf(2.7), pd.min());
        assertEquals(Double.valueOf(9.1), pd.max());
    }
}

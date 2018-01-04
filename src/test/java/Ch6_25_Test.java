import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch6_25_Test {
    @Test
    public void testGenericDeclaration() {
        Method m = null;
        try {
            m = Collections.class.getMethod("checkedSortedMap", SortedMap.class, Class.class, Class.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assertEquals("public static <K,V> java.util.SortedMap<K, V> checkedSortedMap(java.util.SortedMap<K, V>, java.lang.Class<K>, java.lang.Class<V>)",
                Ch6_25.genericDeclaration(m));
    }
}

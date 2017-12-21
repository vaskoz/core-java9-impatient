import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch4_12_Test {
    @Test
    public void reflectVsNormalMethodSpeed() {
        final int iterations = 100_000;
        String str = "Just a string";
        Method m = null;
        try {
            m = String.class.getMethod("contains", CharSequence.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < iterations; i++) {
                m.invoke(str, "string");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long reflectTime = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            str.contains("string");
        }
        long callTime = System.currentTimeMillis() - start;
//        System.out.println("Regular method call time: " + callTime);
//        System.out.println("Reflective method call time: " + reflectTime);
        assertTrue(callTime < reflectTime);
    }
}

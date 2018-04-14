import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ch4_13_Test {
    @Test
    public void testMathSqrt() {
        var want = "java.lang.Math.sqrt\n" +
                "Value: 4.0 returns: 2.0\n" +
                "Value: 6.0 returns: 2.449489742783178\n" +
                "Value: 8.0 returns: 2.8284271247461903\n" +
                "Value: 10.0 returns: 3.1622776601683795\n" +
                "Value: 12.0 returns: 3.4641016151377544\n" +
                "Value: 14.0 returns: 3.7416573867739413\n" +
                "Value: 16.0 returns: 4.0\n";
        var out = new ByteArrayOutputStream(1000);
        try {
            var sqrtMethod = Math.class.getMethod("sqrt", double.class);
            Ch4_13.printTableStaticDoubleValues(new PrintStream(out), sqrtMethod, 4.0, 16.0, 2.0);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertEquals(want, out.toString());
    }

    @Test
    public void testDoubleToHexString() {
        var want = "java.lang.Double.toHexString\n" +
                "Value: 4.0 returns: 0x1.0p2\n" +
                "Value: 6.0 returns: 0x1.8p2\n" +
                "Value: 8.0 returns: 0x1.0p3\n" +
                "Value: 10.0 returns: 0x1.4p3\n" +
                "Value: 12.0 returns: 0x1.8p3\n" +
                "Value: 14.0 returns: 0x1.cp3\n" +
                "Value: 16.0 returns: 0x1.0p4\n";
        var out = new ByteArrayOutputStream(1000);
        try {
            var toHexString = Double.class.getMethod("toHexString", double.class);
            Ch4_13.printTableStaticDoubleValues(new PrintStream(out), toHexString, 4.0, 16.0, 2.0);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertEquals(want, out.toString());
    }

    @Test
    public void testInvalidMethod() {
        try {
            var m = String.class.getMethod("toString");
            assertThrows(IllegalArgumentException.class, () ->
                    Ch4_13.printTableStaticDoubleValues(null, m, 0.0, 1.0, 1.0));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

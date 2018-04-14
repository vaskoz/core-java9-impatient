import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Ch4_13 {
    public static void printTableStaticDoubleValues(PrintStream out, Method method,
                                                    double lower, double upper, double step)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || !Modifier.isStatic(method.getModifiers())
                || method.getParameterTypes().length != 1
                || !(method.getParameterTypes()[0].equals(double.class) && !method.getParameterTypes()[0].equals(Double.class))) {
            throw new IllegalArgumentException("Method must be of form AnyType SomeMethod(OneDouble)");
        }
        out.println(method.getDeclaringClass().getCanonicalName() + "." + method.getName());
        for (var value = lower; value <= upper; value += step) {
            var result = method.invoke(method.getDeclaringClass(), value);
            out.println("Value: " + value + " returns: " + result);
        }
    }
}

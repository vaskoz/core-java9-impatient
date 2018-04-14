import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ch4_10 {
    public static void printMembers(PrintStream out, Class clazz) {
        while (clazz != null) {
            for (var m : clazz.getDeclaredMethods()) {
                out.println(Modifier.toString(m.getModifiers()) + " "
                        + m.getReturnType().getCanonicalName() + " "
                        + m.getName() + Arrays.toString(m.getParameters()));
            }
            clazz = clazz.getSuperclass();
        }
    }
}

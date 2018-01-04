import java.util.concurrent.Callable;
import java.util.function.Function;

public class Ch6_22 {
    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<Throwable, T> constructor) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            throw constructor.apply(realEx);
        }
    }
}

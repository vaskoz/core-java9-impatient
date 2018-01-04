import java.util.concurrent.Callable;

public class Ch6_22 {
    public static <V, T extends Throwable> V doWork(Callable<V> c) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            throw (T) realEx;
        }
    }
}

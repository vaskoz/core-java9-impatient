import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ch6_15 {
    public static <R, T> List<R> map(List<T> list, Function<T, R> func) {
        ArrayList<R> result = new ArrayList<>(list.size());
        for (T e : list) {
            result.add(func.apply(e));
        }
        return result;
    }
}

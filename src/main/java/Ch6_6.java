import java.util.ArrayList;

public class Ch6_6 {
    public static <E> void append(ArrayList<E> destination, ArrayList<E> source) {
        destination.addAll(source);
    }

    public static <E> void append2(ArrayList<? super E> destination, ArrayList<? extends E> source) {
        destination.addAll(source);
    }
}

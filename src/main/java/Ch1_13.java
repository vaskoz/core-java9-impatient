import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ch1_13 {
    public static void main(String[] args) {
        final var size = 49;
        var r = new Random(System.currentTimeMillis());
        var possibles = new ArrayList<Integer>(size + 1);
        for (var i = 1; i <= size; i++) {
            possibles.add(i);
        }
        var picked = new ArrayList<Integer>(6);
        for (var i = 0; i < 6; i++) {
            var pickIndex = r.nextInt(size - i);
            picked.add(possibles.remove(pickIndex));
        }
        Collections.sort(picked);
        for (var i : picked) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}

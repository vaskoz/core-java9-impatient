import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ch1_13 {
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        List<Integer> possibles = new ArrayList<>(50);
        for (int i = 1; i <= 49; i++) {
            possibles.add(i);
        }
        List<Integer> picked = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            int pickIndex = r.nextInt(49);
            picked.add(possibles.remove(pickIndex));
        }
        Collections.sort(picked);
        for (int i : picked) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}

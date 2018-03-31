import java.util.List;
import java.util.Random;

public class Ch2_10 {
    static class RandomNumbers {
        public static int randomElement(int[] data) {
            var rand = new Random();
            if (data.length == 0) {
                return 0;
            }
            var pos = rand.nextInt(data.length);
            return data[pos];
        }

        public static int randomElement(List<Integer> data) {
            var rand = new Random();
            if (data.isEmpty()) {
                return 0;
            }
            var pos = rand.nextInt(data.size());
            return data.get(pos);
        }
    }
}

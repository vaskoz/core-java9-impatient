import java.util.Arrays;

public class Ch5_13 {
    public static int min(int[] values) {
        var smallest = values[0];
        for (var i : values) {
            if (i < smallest) {
                smallest = i;
            }
        }
        var finalSmallest = smallest;
        assert Arrays.stream(values).allMatch(i -> i >= finalSmallest);
        return finalSmallest;
    }
}

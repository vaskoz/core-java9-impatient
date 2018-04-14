import java.util.Random;

public class Ch1_10 {
    public static void main(String[] args) {
        var r = new Random(System.currentTimeMillis());
        var value = r.nextLong();
        System.out.println("" + value + " " + Long.toString(value, 36));
    }
}

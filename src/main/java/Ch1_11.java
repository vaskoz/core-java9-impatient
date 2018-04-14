import java.util.Scanner;
import java.util.function.IntConsumer;

public class Ch1_11 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var line = in.nextLine();
        line.chars().forEach(value -> {
            if (value >= 128) {
                System.out.printf("%s \\u%04x\n", Character.toString((char) value), value);
            }
        });
    }
}

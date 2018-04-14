import java.util.Scanner;

public class Ch1_3 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var one = in.nextInt();
        var two = in.nextInt();
        var three = in.nextInt();
        System.out.printf("Largest using ?: %d\n", one >= two ? one : two >= three ? two : three);
        System.out.printf("Largest using Math.max: %d\n", Math.max(one, Math.max(two, three)));
    }
}

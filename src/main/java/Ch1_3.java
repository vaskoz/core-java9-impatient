import java.util.Scanner;

public class Ch1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int one = in.nextInt();
        int two = in.nextInt();
        int three = in.nextInt();
        System.out.printf("Largest using ?: %d\n", one >= two ? one : two >= three ? two : three);
        System.out.printf("Largest using Math.max: %d\n", Math.max(one, Math.max(two, three)));
    }
}

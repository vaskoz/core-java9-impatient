import java.util.Scanner;

public class Ch1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int angle = in.nextInt();
        System.out.printf("Mod %% 360 is %d\n", angle % 360);
        System.out.printf("Math.floorMod(angle, 360) is %d\n", Math.floorMod(angle, 360));
    }
}

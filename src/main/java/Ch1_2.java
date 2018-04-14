import java.util.Scanner;

public class Ch1_2 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var angle = in.nextInt();
        System.out.printf("Mod %% 360 is %d\n", angle % 360);
        System.out.printf("Math.floorMod(angle, 360) is %d\n", Math.floorMod(angle, 360));
    }
}

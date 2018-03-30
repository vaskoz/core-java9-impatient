import java.util.Scanner;

public class Ch1_1 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var value = in.nextInt();
        System.out.printf("Binary: %s\n", Integer.toBinaryString(value));
        System.out.printf("Octal: %o\n", value);
        System.out.printf("Hexadecimal: %x\n", value);
        var reciprocal = 1.0 / value;
        System.out.printf("Hexadecimal floating point: %a\n", reciprocal);
    }
}

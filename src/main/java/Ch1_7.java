import java.math.BigInteger;
import java.util.Scanner;

public class Ch1_7 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        // Read as long from Scanner, but stored as ints
        var one = (int) in.nextLong();
        var two = (int) in.nextLong();

        System.out.printf("Unsigned sum: %d\n", convertFromInt(one) + convertFromInt(two));
        System.out.printf("Difference: %d\n", convertFromInt(one) - convertFromInt(two));
        System.out.printf("Product: %d\n", BigInteger.valueOf(convertFromInt(one)).multiply(BigInteger.valueOf(convertFromInt(two))));
        System.out.printf("Quotient: %d\n", convertFromInt(one) / convertFromInt(two));
        System.out.printf("Remainder: %d\n", convertFromInt(one) % convertFromInt(two));
    }

    private static long convertFromInt(int value) {
        return value > 0 ? value : 2L * Integer.MAX_VALUE + value + 2;
    }
}

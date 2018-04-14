import java.math.BigInteger;

public class Ch5_11 {
    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be negative");
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        var walker = StackWalker.getInstance();
        walker.forEach(stackFrame -> {
            if (stackFrame.getClassName().equals("Ch5_11")) {
                System.out.println(stackFrame);
            }
        });
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}

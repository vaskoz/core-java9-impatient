public class Ch1_4 {
    public static void main(String[] args) {
        System.out.printf("Smallest positive double: %g\n", Math.nextUp(0.0));
        System.out.printf("Largest positive double: %g\n", Math.nextDown(Double.POSITIVE_INFINITY));
    }
}

public class Ch1_5 {
    public static void main(String[] args) {
        var x = 1.0 + Integer.MAX_VALUE;
        System.out.printf("Double 1.0 + Integer.MAX_VALUE %g as int %d Integer.MAX_VALUE %d\n", x, (int) x, Integer.MAX_VALUE);
        var y = 2000000000.0 + Integer.MAX_VALUE;
        System.out.printf("Double 2000000000.0 + Integer.MAX_VALUE %g as int %d Integer.MAX_VALUE %d\n", y, (int) y, Integer.MAX_VALUE);
    }
}

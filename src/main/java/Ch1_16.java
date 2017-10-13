public class Ch1_16 {
    public static double averageBook(double... args) {
        double result = 0.0;
        for (double d : args) {
            result += d;
        }
        return args.length == 0 ? 0 : result / args.length;
    }

    public static double averageAtLeastOne(double first, double... args) {
        double result = first;
        for (double d : args) {
            result += d;
        }
        return result / (args.length+1);
    }
}

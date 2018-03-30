public class Ch1_16 {
    public static double averageBook(double... args) {
        var result = 0.0;
        for (var d : args) {
            result += d;
        }
        return args.length == 0 ? 0 : result / args.length;
    }

    public static double averageAtLeastOne(double first, double... args) {
        var result = first;
        for (var d : args) {
            result += d;
        }
        return result / (args.length + 1);
    }
}

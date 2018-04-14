import java.io.FileNotFoundException;

public class Ch5_3 {
    public static void main(String... args) {
        var app = new Ch5_2();
        if (args.length != 1) {
            System.err.println("must provide filename to read doubles");
            return;
        }
        try {
            System.out.println(app.sumOfValues(args[0]));
        } catch (FileNotFoundException e) {
            System.err.println(String.format("File \"%s\" could not be found. ", args[0]) + e.getMessage());
        }
    }
}

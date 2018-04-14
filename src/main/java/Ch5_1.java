import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ch5_1 {
    public ArrayList<Double> readValues(String filename) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("invalid filename");
        }
        var result = new ArrayList<Double>();
        var in = new Scanner(new File(filename));
        while (in.hasNextDouble()) {
            result.add(in.nextDouble());
        }
        return result;
    }
}

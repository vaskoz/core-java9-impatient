import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Ch5_2 {
    public double sumOfValues(String filename) throws FileNotFoundException {
        Ch5_1 delegate = new Ch5_1();
        ArrayList<Double> data = delegate.readValues(filename);
        double result = 0.0;
        for (double d : data) {
            result += d;
        }
        return result;
    }
}

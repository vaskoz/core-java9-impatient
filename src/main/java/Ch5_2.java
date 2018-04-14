import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Ch5_2 {
    public double sumOfValues(String filename) throws FileNotFoundException {
        var delegate = new Ch5_1();
        var data = delegate.readValues(filename);
        var result = 0.0;
        for (var d : data) {
            result += d;
        }
        return result;
    }
}

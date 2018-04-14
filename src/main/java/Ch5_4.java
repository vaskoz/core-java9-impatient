import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch5_4 {
    private Status readValues(String filename, List<Double> result) {
        if (filename == null || filename.isEmpty()) {
            return Status.FileNotFound;
        }
        Scanner in;
        try {
            in = new Scanner(new File(filename));
            while (in.hasNextDouble()) {
                result.add(in.nextDouble());
            }
        } catch (FileNotFoundException e) {
            return Status.FileNotFound;
        }
        return Status.Success;
    }

    public Status sumOfValues(String filename, List<Double> result) {
        var doubles = new ArrayList<Double>();
        var statusCode = this.readValues(filename, doubles);
        if (statusCode != Status.Success) {
            return statusCode;
        }
        var sum = 0.0;
        for (var d : doubles) {
            sum += d;
        }
        result.add(sum);
        return Status.Success;
    }

    public enum Status {
        Success, FileNotFound
    }
}

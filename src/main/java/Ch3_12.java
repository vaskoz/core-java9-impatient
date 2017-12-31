import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch3_12 {
    public static List<String> findByExtension(String directory, String extension) {
        File dir = new File(directory);
        // capture "extension" variable in lambda expression
        String[] files = dir.list((dir1, name) -> name.endsWith(extension));
        List<String> result = new ArrayList<>(Arrays.asList(files));
        return result;
    }
}

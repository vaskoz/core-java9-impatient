import java.io.File;
import java.util.Arrays;

public class Ch3_13 {
    public static void sortFiles(File[] files) {
        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() && !o2.isDirectory()) {
                return -1;
            } else if (!o1.isDirectory() && o2.isDirectory()) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });
    }
}

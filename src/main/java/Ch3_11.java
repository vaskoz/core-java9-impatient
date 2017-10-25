import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch3_11 {
    static List<File> getSubdirectories(String pathname) {
        List<File> result = new ArrayList<>();
        File path = new File(pathname);
        File[] subdirs = path.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        result.addAll(Arrays.asList(subdirs));
        return result;
    }

    static List<File> getSubdirectoriesLambda(String pathname) {
        List<File> result = new ArrayList<>();
        File path = new File(pathname);
        File[] subdirs = path.listFiles(pathname1 -> pathname1.isDirectory());
        result.addAll(Arrays.asList(subdirs));
        return result;
    }

    static List<File> getSubdirectoriesReference(String pathname) {
        List<File> result = new ArrayList<>();
        File path = new File(pathname);
        File[] subdirs = path.listFiles(File::isDirectory);
        result.addAll(Arrays.asList(subdirs));
        return result;
    }
}

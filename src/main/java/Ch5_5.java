import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ch5_5 {
    public static void copyLowerCase(File src, File dest) {
        if (src == null || dest == null) {
            System.err.printf("File could not be found source: %s and destination: %s", src, dest);
            return;
        }
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(src);
            out = new PrintWriter(dest);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.err.printf("File could not be found source: %s and destination: %s", src, dest);
        } finally {
            if (in != null) {
                in.close(); // Doesn't throw an exception. captured Exception @see boolean checkError()
            }
            if (out != null) {
                out.close(); // Doesn't throw an exception. captured Exception @see boolean checkError()
            }
        }
    }
}

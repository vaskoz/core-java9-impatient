import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ch7_8 {
    public static void main(String... args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException("must provide a filename");
        }
        Map<String, Set<String>> counts = new HashMap<>();
        try (Scanner in = new Scanner(new File(args[0]))) {
            int line = 1;
            while (in.hasNextLine()) {
                String[] words = in.nextLine().split(" ");
                for (String word : words) {
                    Set<String> lines = counts.getOrDefault(word, new TreeSet<>());
                    lines.add(String.valueOf(line));
                    counts.put(word, lines);
                }
                line++;
            }
        }
        for (Map.Entry<String, Set<String>> entry : counts.entrySet()) {
            System.out.println("Word is: " + entry.getKey() + " with lines: " + "".join(",", entry.getValue()));
        }
    }
}

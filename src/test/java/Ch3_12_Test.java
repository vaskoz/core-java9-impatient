import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_12_Test {
    private static File[] createdFiles;
    private static List<String> expected;

    @BeforeAll
    public static void setup() {
        try {
            createdFiles = new File[]{
                    Files.createTempFile("a", ".tmp").toFile(),
                    Files.createTempFile("me", ".foobar").toFile(),
                    Files.createTempFile("m", ".tmp").toFile(),
                    Files.createTempFile("nye", ".foobar").toFile(),
                    Files.createTempFile("x", ".tmp").toFile()
            };
            expected = List.of(createdFiles[1].getName(), createdFiles[3].getName());
        } catch (IOException ioe) {
        }
    }

    @AfterAll
    public static void teardown() {
        for (var f : createdFiles) {
            try {
                Files.deleteIfExists(f.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void findFilesByExtension() {
        var tmpDir = createdFiles[0].getParent();
        var results = Ch3_12.findByExtension(tmpDir, ".foobar");
        Collections.sort(results);
        assertEquals(expected, results);
    }
}

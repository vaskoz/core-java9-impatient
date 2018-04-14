import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Ch3_11_Test {
    private static Path tempDir;
    private static Deque<File> dirs = new ArrayDeque<>();

    @BeforeAll
    public static void setup() {
        try {
            tempDir = Files.createTempDirectory(null);
            var td = tempDir.toFile();
            var sd1 = new File(td, "bar");
            assertTrue(sd1.mkdir());
            var sd2 = new File(td, "baz");
            assertTrue(sd2.mkdir());
            dirs.push(td);
            dirs.push(sd1);
            dirs.push(sd2);
        } catch (IOException e) {
            fail("Couldn't create a temporary directory", e);
        }
    }

    @AfterAll
    public static void teardown() {
        while (!dirs.isEmpty()) {
            var f = dirs.pop();
            assertTrue(f.delete());
        }
    }

    @Test
    public void testGetSubdirectories() {
        var result = Ch3_11.getSubdirectories(tempDir.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testGetSubdirectoriesLambda() {
        var result = Ch3_11.getSubdirectoriesLambda(tempDir.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testGetSubdirectoriesReference() {
        var result = Ch3_11.getSubdirectoriesReference(tempDir.toString());
        assertEquals(2, result.size());
    }
}

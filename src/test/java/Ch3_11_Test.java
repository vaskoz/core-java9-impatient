import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class Ch3_11_Test {
    private static Path tempDir;
    private static Stack<File> dirs = new Stack<>();

    @BeforeAll
    public static void setup() {
        try {
            tempDir = Files.createTempDirectory(null);
            File td = tempDir.toFile();
            File sd1 = new File(td, "bar");
            assertTrue(sd1.mkdir());
            File sd2 = new File(td, "baz");
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
        while (!dirs.empty()) {
            File f = dirs.pop();
            assertTrue(f.delete());
        }
    }

    @Test
    public void testGetSubdirectories() {
        List<File> result = Ch3_11.getSubdirectories(tempDir.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testGetSubdirectoriesLambda() {
        List<File> result = Ch3_11.getSubdirectoriesLambda(tempDir.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testGetSubdirectoriesReference() {
        List<File> result = Ch3_11.getSubdirectoriesReference(tempDir.toString());
        assertEquals(2, result.size());
    }
}

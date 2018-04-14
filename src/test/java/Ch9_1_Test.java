import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch9_1_Test {
    @Test
    public void copyStream() {
        var data = "hello world string chapter 9 question 1";
        var in = new ByteArrayInputStream(data.getBytes());
        var out = new ByteArrayOutputStream();
        Ch9_1.copyStream(out, in);
        assertEquals(data, out.toString());
    }

    @Test
    public void badCopyStream() {
        var data = "hello world string chapter 9 question 1";
        var in = new ByteArrayInputStream(data.getBytes()) {
            @Override
            public long transferTo(OutputStream out) throws IOException {
                throw new IOException("I never really wanted to transfer");
            }
        };
        var out = new ByteArrayOutputStream();
        Ch9_1.copyStream(out, in);
        assertEquals(0, out.size());
    }

    @Test
    void badStreamClose() {
        var originalErr = System.err;
        var stderrStream = new ByteArrayOutputStream();
        var stderr = new PrintStream(stderrStream, true);
        System.setErr(stderr);
        var data = "hello world string chapter 9 question 1";
        var in = new ByteArrayInputStream(data.getBytes()) {
            @Override
            public long transferTo(OutputStream out) throws IOException {
                throw new IOException("I never really wanted to transfer");
            }

            @Override
            public void close() throws IOException {
                throw new IOException("Input won't close");
            }
        };
        var out = new ByteArrayOutputStream() {
            @Override
            public void close() throws IOException {
                throw new IOException("Output won't close");
            }
        };
        Ch9_1.copyStream(out, in);
        assertEquals(0, out.size());
        var stderrString = stderrStream.toString();
        assertTrue(stderrString.contains("Input won't close"));
        assertTrue(stderrString.toString().contains("Output won't close"));
        System.setErr(originalErr);
    }
}

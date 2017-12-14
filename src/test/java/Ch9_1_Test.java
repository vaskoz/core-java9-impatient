import java.io.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch9_1_Test {
    @Test
    public void copyStream() {
        String data = "hello world string chapter 9 question 1";
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Ch9_1.copyStream(out, in);
        assertEquals(data, out.toString());
    }

    @Test
    public void badCopyStream() {
        String data = "hello world string chapter 9 question 1";
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes()) {
            @Override
            public long transferTo(OutputStream out) throws IOException {
                throw new IOException("I never really wanted to transfer");
            }
        };
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Ch9_1.copyStream(out, in);
        assertEquals(0, out.size());
    }

    @Test
    void badStreamClose() {
        PrintStream originalErr = System.err;
        ByteArrayOutputStream stderrStream = new ByteArrayOutputStream();
        PrintStream stderr = new PrintStream(stderrStream, true);
        System.setErr(stderr);
        String data = "hello world string chapter 9 question 1";
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes()) {
            @Override
            public long transferTo(OutputStream out) throws IOException {
                throw new IOException("I never really wanted to transfer");
            }

            @Override
            public void close() throws IOException {
                throw new IOException("Input won't close");
            }
        };
        ByteArrayOutputStream out = new ByteArrayOutputStream() {
            @Override
            public void close() throws IOException {
                throw new IOException("Output won't close");
            }
        };
        Ch9_1.copyStream(out, in);
        assertEquals(0, out.size());
        String stderrString = stderrStream.toString();
        assertTrue(stderrString.contains("Input won't close"));
        assertTrue(stderrString.toString().contains("Output won't close"));
        System.setErr(originalErr);
    }
}

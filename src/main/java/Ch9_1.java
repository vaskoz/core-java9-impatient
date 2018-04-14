import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class Ch9_1 {
    public static void copyStream(OutputStream dest, InputStream src) {
        Objects.requireNonNull(src, "InputStream cannot be null");
        Objects.requireNonNull(dest, "OutputStream cannot be null");
        try (var in = src; OutputStream out = dest) {
            in.transferTo(out);
        } catch (IOException e) {
            try {
                src.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                dest.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

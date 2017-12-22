import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch4_9_Test {
    private static Ch4_9 app;

    @BeforeAll
    public static void setup() {
        app = new Ch4_9();
    }

    @AfterAll
    public static void teardown() {
        app = null;
    }

    @ParameterizedTest
    @CsvSource({"3, 4, 5, 'x:unable to access\ny:4\nz:5\n'"})
    public void testA(int x, int y, int z, String fragment) {
        Ch4_9.A a = app.new A(x, y, z);
        String[] parts = fragment.split("\n");
        String result = a.toString();
        for (String part : parts) {
            assertTrue(result.contains(part + "\n"));
        }
    }

    @ParameterizedTest
    @CsvSource({"'foo', 'bar', 'baz', 'a:unable to access\nb:unable to access\nc:baz\n'"})
    public void testB(String a, String b, String c, String fragment) {
        Ch4_9.B bb = app.new B(a, b, c);
        String[] parts = fragment.split("\n");
        String result = bb.toString();
        for (String part : parts) {
            assertTrue(result.contains(part + "\n"));
        }
    }
}

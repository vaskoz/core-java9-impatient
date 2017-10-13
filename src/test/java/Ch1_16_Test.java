import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_16_Test {
    @Test
    void averageBook() {
        assertEquals(0, Ch1_16.averageBook());
        assertEquals(10, Ch1_16.averageBook(10));
        assertEquals(15, Ch1_16.averageBook(10, 20));
    }

    @Test
    void averageAtLeastOne() {
        // assertEquals(0, Ch1_16.averageAtLeastOne()); // wouldn't compile w/o 1 argument.
        assertEquals(10, Ch1_16.averageAtLeastOne(10));
        assertEquals(15, Ch1_16.averageAtLeastOne(10, 20));
    }

}

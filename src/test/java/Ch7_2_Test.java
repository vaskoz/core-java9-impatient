import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch7_2_Test {
    private static ArrayList<String> expectation;
    private ArrayList<String> input;

    @BeforeAll
    public static void setupExpectation() {
        expectation = new ArrayList<>(Arrays.asList("YESTERDAY", "TODAY", "TOMORROW"));
    }

    @BeforeEach
    public void setup() {
        this.input = new ArrayList<>(Arrays.asList("yesterday", "Today", "tomoRRow"));
    }

    @Test
    public void testToUpperCaseA() {
        assertEquals(expectation, Ch7_2.toUpperCaseA(this.input));
    }

    @Test
    public void testToUpperCaseB() {
        assertEquals(expectation, Ch7_2.toUpperCaseB(this.input));
    }

    @Test
    public void testToUpperCaseC() {
        assertEquals(expectation, Ch7_2.toUpperCaseC(this.input));
    }
}

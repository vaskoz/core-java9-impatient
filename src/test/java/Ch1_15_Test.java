import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1_15_Test {
    private static PrintStream originalOut;
    private static InputStream originalIn;
    private final String input = "5";
    private final String want = "1 \n" +
            "1 1 \n" +
            "1 2 1 \n" +
            "1 3 3 1 \n" +
            "1 4 6 4 1 \n" +
            "1 5 10 10 5 1 \n";
    private ByteArrayOutputStream out;

    @BeforeAll
    static void saveOriginals() {
        originalOut = System.out;
        originalIn = System.in;
    }

    @AfterAll
    static void restoreOriginals() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @BeforeEach
    void setupInput() {
        var in = new ByteArrayInputStream(input.getBytes());
        this.out = new ByteArrayOutputStream(this.want.length() * 2);
        System.setOut(new PrintStream(this.out));
        System.setIn(in);
    }

    @Test
    void check() {
        Ch1_15.main(null);
        assertEquals(this.want, this.out.toString());
    }

    @Test
    void direct() {
        var prob = new Ch1_15(5);
        var result = prob.pascalsTriangle();
        assertEquals(6, result.size());
        var answer = new int[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1},
                {1, 5, 10, 10, 5, 1},
        };
        for (var i = 0; i < answer.length; i++) {
            for (var j = 0; j < answer[i].length; j++) {
                assertEquals(answer[i][j], (int) result.get(i).get(j));
            }
        }
    }

}

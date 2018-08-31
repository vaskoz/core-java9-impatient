import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch13_4_Test {
    @Test
    public void getAllLanguages() {
        assertEquals(19161, Ch13_4.getAllLanguages().size());
    }
}

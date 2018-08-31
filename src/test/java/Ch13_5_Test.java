import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch13_5_Test {
    @Test
    public void getAllCurrencies() {
        assertEquals(21241, Ch13_5.getAllCurrencies().size());
    }
}

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch2_15_Test {
    @Test
    public void testInvoice() {
        String want = "Item{description='itemA', quantity=2, unitPrice=10.2}\n" +
                "Item{description='itemB', quantity=20, unitPrice=1.2}\n" +
                "Item{description='itemC', quantity=100, unitPrice=20.2}\n";
        Ch2_15.Invoice inv = new Ch2_15.Invoice();
        inv.add(new Ch2_15.Invoice.Item("itemA", 2, 10.2));
        inv.add(new Ch2_15.Invoice.Item("itemB", 20, 1.2));
        inv.add(new Ch2_15.Invoice.Item("itemC", 100, 20.2));

        ByteArrayOutputStream out = new ByteArrayOutputStream(5000);
        inv.print(new PrintStream(out));
        assertEquals(want, out.toString());
    }
}

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch2_15_Test {
    @Test
    public void testInvoice() {
        var want = "Item{description='itemA', quantity=2, unitPrice=10.2}\n" +
                "Item{description='itemB', quantity=20, unitPrice=1.2}\n" +
                "Item{description='itemC', quantity=100, unitPrice=20.2}\n";
        var inv = new Ch2_15.Invoice();
        inv.add(new Ch2_15.Invoice.Item("itemA", 2, 10.2));
        inv.add(new Ch2_15.Invoice.Item("itemB", 20, 1.2));
        inv.add(new Ch2_15.Invoice.Item("itemC", 100, 20.2));

        var out = new ByteArrayOutputStream(5000);
        inv.print(new PrintStream(out));
        assertEquals(want, out.toString());
    }
}

import java.io.PrintStream;
import java.util.ArrayList;

public class Ch2_15 {
    public static class Invoice {
        private final ArrayList<Item> items = new ArrayList<>();

        public void add(Item item) {
            items.add(item);
        }

        public void print(PrintStream printer) {
            for (Item item : items) {
                printer.println(item);
            }
        }

        public static class Item { // Item is nested inside Invoice
            private String description;
            private int quantity;
            private double unitPrice;

            public Item(String description, int quantity, double unitPrice) {
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            public double price() {
                return quantity * unitPrice;
            }

            public String getDescription() {
                return description;
            }

            public int getQuantity() {
                return quantity;
            }

            public double getUnitPrice() {
                return unitPrice;
            }

            @Override
            public String toString() {
                return "Item{" +
                        "description='" + description + '\'' +
                        ", quantity=" + quantity +
                        ", unitPrice=" + unitPrice +
                        '}';
            }
        }
    }
}

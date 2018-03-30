import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch1_14 {
    private final int dim;
    private final List<Integer> data;

    public Ch1_14(int dim, List<Integer> data) {
        this.dim = dim;
        this.data = data;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var data = new ArrayList<Integer>();
        var dim = 0;
        for (var line = in.nextLine(); !line.isEmpty(); line = in.nextLine()) {
            String[] parts = line.split(" ");
            dim = parts.length;
            for (var part : parts) {
                data.add(Integer.valueOf(part));
            }
        }
        Ch1_14 prob = new Ch1_14(dim, data);
        System.out.printf("Is Magic?: %b\n", prob.isMagic());
    }

    public boolean isMagic() {
        var sum = 0;
        for (var i = 0; i < this.dim; i++) {
            sum += this.data.get(i);
        }
        // Check diagonals
        var diaglrSum = 0;
        var diagrlSum = 0;
        for (var row = 0; row < this.data.size() / this.dim; row++) {
            // Check rows
            var rowSum = 0;
            for (var col = row * this.dim; col < (row + 1) * this.dim; col++) {
                rowSum += this.data.get(col);
            }
            if (rowSum != sum) {
                return false;
            }
            // Check columns
            var colSum = 0;
            for (var col = row; col < this.data.size(); col = col + this.dim) {
                colSum += this.data.get(col);
            }
            if (colSum != sum) {
                return false;
            }
            diaglrSum += this.data.get(row * this.dim + row);
            diagrlSum += this.data.get((this.dim - row - 1) * this.dim + (this.dim - row - 1));
        }
        return diaglrSum == sum && diagrlSum == sum;
    }
}

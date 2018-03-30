import java.util.ArrayList;
import java.util.Scanner;

public class Ch1_15 {
    private final int n;

    public Ch1_15(int n) {
        this.n = n;
    }

    public ArrayList<ArrayList<Integer>> pascalsTriangle() {
        var result = new ArrayList<ArrayList<Integer>>(this.n);
        for (var row = 0; row <= this.n; row++) {
            var nextRow = new ArrayList<Integer>(row + 1);
            if (row == 0) {
                nextRow.add(1);
            } else if (row == 1) {
                nextRow.add(1);
                nextRow.add(1);
            } else {
                var prev = result.get(row - 1);
                nextRow.add(1);
                for (var pos = 1; pos < row; pos++) {
                    nextRow.add(prev.get(pos - 1) + prev.get(pos));
                }
                nextRow.add(1);
            }
            result.add(nextRow);
        }
        return result;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var n = in.nextInt();
        var prob = new Ch1_15(n);
        var triangle = prob.pascalsTriangle();
        for (var list : triangle) {
            for (var i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}

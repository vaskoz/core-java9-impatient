public class Ch2_4 {
    private static class IntHolder {
        private int value;

        public IntHolder(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%d", this.value);
        }
    }

    public static void main(String[] args) {
        var a = 1;
        var b = 2;
        System.out.printf("Before 'cantSwap(a,b)' a=%d and b=%d\n", a, b);
        cantSwap(a, b);
        System.out.printf("After 'cantSwap(a,b)' a=%d and b=%d\n", a, b);
        var ah = new IntHolder(1);
        var bh = new IntHolder(2);
        System.out.printf("Before 'canSwap(ah,bh)' a=%s and b=%s\n", ah, bh);
        canSwap(ah, bh);
        System.out.printf("After 'canSwap(ah,bh)' a=%s and b=%s\n", ah, bh);
    }

    private static void canSwap(IntHolder ah, IntHolder bh) {
        var temp = ah.getValue();
        ah.setValue(bh.getValue());
        bh.setValue(temp);
    }


    /**
     * Try to swap these, but this won't affect the variables being passed in.
     *
     * @param a
     * @param b
     */
    private static void cantSwap(int a, int b) {
        var temp = a;
        b = a;
        a = temp;
    }
}

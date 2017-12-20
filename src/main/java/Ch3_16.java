import java.util.Random;

public class Ch3_16 {
    private static Random generator = new Random();

    public static interface IntSequence {
        boolean hasNext();

        int next();
    }

    private static class RandomSequence implements IntSequence {
        private final int low;
        private final int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return this.low + generator.nextInt(this.high - this.low + 1);
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }
}

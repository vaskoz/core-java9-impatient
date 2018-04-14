public class Ch3_4 {
    interface IntSequence {
        static IntSequence of(int... list) {
            // Extra credit for anonymous inner class.
            return new IntSequence() {
                private int pos = 0;

                @Override
                public boolean hasNext() {
                    return pos < list.length;
                }

                @Override
                public int next() {
                    return hasNext() ? list[pos++] : 0;
                }
            };
        }

        boolean hasNext();

        int next();
    }
}

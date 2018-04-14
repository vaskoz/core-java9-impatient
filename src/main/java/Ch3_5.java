public class Ch3_5 {
    interface IntSequence {
        static IntSequence constant(int c) {
            // Extra credit for lambda.
            return () -> c;
        }

        default boolean hasNext() {
            return true;
        }
        
        int next();
    }
}

public class Ch3_14 {
    public static Runnable inOrder(Runnable[] runnables) {
        return () -> {
            for (Runnable r : runnables) {
                r.run();
            }
        };
    }
}

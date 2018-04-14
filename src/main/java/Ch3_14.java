public class Ch3_14 {
    public static Runnable inOrder(Runnable[] runnables) {
        return () -> {
            for (var r : runnables) {
                r.run();
            }
        };
    }
}

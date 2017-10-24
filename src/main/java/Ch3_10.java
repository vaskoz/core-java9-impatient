import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ch3_10 {
    public static void runTogether(Runnable... tasks) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(tasks.length);
        for (Runnable task : tasks) {
            es.submit(task);
        }
        es.awaitTermination(1, TimeUnit.SECONDS);
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }
}

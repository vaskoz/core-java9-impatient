import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ch3_10 {
    public static void runTogether(Runnable... tasks) throws InterruptedException {
        var es = Executors.newFixedThreadPool(tasks.length);
        for (var task : tasks) {
            es.submit(task);
        }
        es.awaitTermination(1, TimeUnit.SECONDS);
    }

    public static void runInOrder(Runnable... tasks) {
        for (var task : tasks) {
            task.run();
        }
    }
}

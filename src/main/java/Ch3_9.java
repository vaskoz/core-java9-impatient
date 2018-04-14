import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Ch3_9 {
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String... args) throws Exception {
        var app = new Ch3_9();
        var es = Executors.newFixedThreadPool(2);
        es.submit(app.new Greeter(10, "tom"));
        es.submit(app.new Greeter(5, "tim"));
        es.awaitTermination(500, TimeUnit.MILLISECONDS);
    }

    private class Greeter implements Runnable {
        private final int n;
        private final String target;

        public Greeter(int n, String target) {
            this.n = n;
            this.target = target;
        }

        @Override
        public void run() {
            for (var i = 0; i < this.n; i++) {
                Ch3_9.this.lock.lock();
                System.out.println("Hello, " + this.target);
                Ch3_9.this.lock.unlock();
            }
        }
    }
}

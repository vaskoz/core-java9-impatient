import java.util.concurrent.locks.ReentrantLock;

public class Ch5_9 {
    public static AutoCloseableReentrantLock lock() {
        var reentrantLock = new AutoCloseableReentrantLock();
        reentrantLock.lock();
        return reentrantLock;
    }

    public static class AutoCloseableReentrantLock extends ReentrantLock implements AutoCloseable {
        @Override
        public void close() {
            this.unlock();
        }
    }
}

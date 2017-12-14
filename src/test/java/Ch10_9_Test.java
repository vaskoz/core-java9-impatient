import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ch10_9_Test {
    @Test
    public void testAtomicLong() {
        AtomicLong atomicLong = new AtomicLong();
        List<Thread> threads = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100_000; j++) {
                        atomicLong.addAndGet(1);
                    }
                }
            }));
            threads.get(i).start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testLongAddr() {
        LongAdder longAdder = new LongAdder();
        List<Thread> threads = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100_000; j++) {
                        longAdder.add(1);
                    }
                }
            }));
            threads.get(i).start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

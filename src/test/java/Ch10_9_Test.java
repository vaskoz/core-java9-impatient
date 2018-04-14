import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ch10_9_Test {
    @Test
    public void testAtomicLong() {
        var atomicLong = new AtomicLong();
        var threads = new ArrayList<Thread>(1000);
        for (var i = 0; i < 1000; i++) {
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
        for (var t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testLongAddr() {
        var longAdder = new LongAdder();
        var threads = new ArrayList<Thread>(1000);
        for (var i = 0; i < 1000; i++) {
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
        for (var t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

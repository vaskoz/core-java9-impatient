import java.util.LinkedHashMap;
import java.util.Map;

public class Ch7_13 {
    static class Cache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public Cache(int initialCapacity) {
            super(initialCapacity);
            this.capacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return this.size() > this.capacity;
        }
    }
}

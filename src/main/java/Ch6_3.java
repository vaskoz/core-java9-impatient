import java.util.ArrayList;

public class Ch6_3 {
    /**
     * Assumes that equals and hashcode are implemented.
     * O(n) time complexity since problem said to use ArrayList.
     *
     * @param <K>
     * @param <V>
     */
    class Table<K, V> {
        private ArrayList<Entry<K, V>> data;

        public Table() {
            this.data = new ArrayList<>();
        }

        public void remove(K key) {
            for (Entry<K, V> entry : this.data) {
                if (entry.getKey().equals(key)) {
                    this.data.remove(entry);
                    return;
                }
            }
        }

        public V get(K key) {
            for (Entry<K, V> entry : this.data) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            return null;
        }

        public void set(K key, V value) {
            for (Entry<K, V> entry : this.data) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
            this.data.add(new Entry<>(key, value));
        }
    }

    class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

import java.util.ArrayList;

public class Ch6_1 {
    class Stack<E> {
        private ArrayList<E> data;

        public Stack(int initialSize) {
            this.data = new ArrayList<>(initialSize);
        }

        public void push(E item) {
            this.data.add(item);
        }

        public E pop() {
            if (this.data.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return this.data.remove(this.data.size() - 1);
        }

        public boolean isEmpty() {
            return this.data.isEmpty();
        }
    }
}

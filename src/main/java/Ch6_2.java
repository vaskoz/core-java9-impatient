import java.util.Arrays;

public class Ch6_2 {
    class StackEA<E> {
        private E[] data;
        private int pos = 0;

        @SuppressWarnings("unchecked")
        public StackEA(int initialSize) {
            if (initialSize <= 0) {
                throw new IllegalArgumentException("size must be greater than 0");
            }
            this.data = (E[]) new Object[initialSize];
        }

        public void push(E item) {
            if (pos == data.length) {
                this.data = Arrays.copyOf(this.data, this.data.length * 2);
            }
            this.data[pos++] = item;
        }

        public E pop() {
            if (this.pos == 0) {
                throw new IllegalStateException("stack is empty");
            }
            return this.data[--pos];
        }

        public boolean isEmpty() {
            return this.pos == 0;
        }
    }

    class StackOA<E> {
        private Object[] data;
        private int pos = 0;

        @SuppressWarnings("unchecked")
        public StackOA(int initialSize) {
            if (initialSize <= 0) {
                throw new IllegalArgumentException("size must be greater than 0");
            }
            this.data = new Object[initialSize];
        }

        public void push(E item) {
            if (pos == data.length) {
                this.data = Arrays.copyOf(this.data, this.data.length * 2);
            }
            this.data[pos++] = item;
        }

        @SuppressWarnings("unchecked")
        public E pop() {
            if (this.pos == 0) {
                throw new IllegalStateException("stack is empty");
            }
            return (E) this.data[--pos];
        }

        public boolean isEmpty() {
            return this.pos == 0;
        }
    }
}

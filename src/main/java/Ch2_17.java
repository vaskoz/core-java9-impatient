public class Ch2_17 {
    static class Queue {
        private Node head;
        private Node tail;

        public void add(String s) {
            var n = new Node(s);
            if (this.head == null) {
                this.head = n;
                this.tail = n;
            } else {
                this.tail.next = n;
                this.tail = n;
            }
        }

        public String remove() {
            if (this.head == null) {
                return null;
            } else {
                var n = this.head;
                this.head = this.head.next;
                return n.getData();
            }
        }

        public java.util.Iterator<String> iterator() {
            return new Iterator();
        }

        private class Node {
            private final String data;
            Node prev, next;

            public Node(String data) {
                this.data = data;
            }

            public String getData() {
                return data;
            }
        }

        private class Iterator implements java.util.Iterator<String> {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                var result = hasNext() ? current.getData() : null;
                this.current = hasNext() ? this.current.next : null;
                return result;
            }
        }
    }
}

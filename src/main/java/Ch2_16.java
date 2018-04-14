public class Ch2_16 {
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
    }
}

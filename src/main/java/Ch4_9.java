public class Ch4_9 {
    static class UniversalToString {
        public static String toString(Object obj) {
            var sb = new StringBuilder();
            var clazz = obj.getClass();
            for (var f : clazz.getDeclaredFields()) {
                sb.append(f.getName());
                sb.append(":");
                try {
                    sb.append(f.get(obj));
                } catch (IllegalAccessException e) {
                    sb.append("unable to access");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    class A {
        public final int z;
        protected final int y;
        private final int x;

        public A(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return UniversalToString.toString(this);
        }
    }

    class B {
        private final String a, b;
        String c;

        public B(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return UniversalToString.toString(this);
        }
    }
}

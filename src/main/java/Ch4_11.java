public class Ch4_11 {
    public static final String message = "Hello, World!";

    public static void main(String... args) throws Exception {
        var clazz = Class.forName("java.lang.System");
        var out = clazz.getDeclaredField("out");
        var outPs = out.getType();
        var println = outPs.getMethod("println", String.class);
        println.invoke(out.get(null), message);
    }
}

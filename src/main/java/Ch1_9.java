public class Ch1_9 {
    public static void main(String[] args) {
        var s = new String("my string");
        var t = new String("my string");
        System.out.printf("new String(\"my string\").equals(new String(\"my string\")) should be true is %b\n", s.equals(t));
        System.out.printf("new String(\"my string\") == new String(\"my string\") should be false is %b\n", s == t);
    }
}

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch4_10_Test {
    String expected = "protected void finalize[]\n" +
            "public final native void wait[long arg0]\n" +
            "public final void wait[long arg0, int arg1]\n" +
            "public final void wait[]\n" +
            "public boolean equals[java.lang.Object arg0]\n" +
            "public java.lang.String toString[]\n" +
            "public native int hashCode[]\n" +
            "public final native java.lang.Class getClass[]\n" +
            "protected native java.lang.Object clone[]\n" +
            "public final native void notify[]\n" +
            "public final native void notifyAll[]\n" +
            "private static native void registerNatives[]\n";

    @Test
    public void testMembersOfIntArray() {
        var clazz = int[].class;
        var out = new ByteArrayOutputStream(5000);
        Ch4_10.printMembers(new PrintStream(out), clazz);
        assertEquals(expected, out.toString());
    }

    @Test
    public void testMembersOfObject() {
        var clazz = Object.class;
        var out = new ByteArrayOutputStream(5000);
        Ch4_10.printMembers(new PrintStream(out), clazz);
        assertEquals(expected, out.toString());
    }
}

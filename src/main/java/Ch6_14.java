import java.util.List;

public class Ch6_14 {
    public static <T extends AutoCloseable> void closeAll(List<T> elems) throws Exception {
        Exception ex = null;
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                ex = new Exception(e.getMessage(), ex);
            }
        }
        if (ex != null) {
            throw ex;
        }
    }
}

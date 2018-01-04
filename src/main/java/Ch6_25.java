import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringJoiner;

public class Ch6_25 {
    public static String genericDeclaration(Method m) {
        StringBuilder sb = new StringBuilder();
        int modifiers = m.getModifiers();
        sb.append(Modifier.toString(modifiers));
        TypeVariable<Method>[] types = m.getTypeParameters();
        StringJoiner sj = new StringJoiner(",");
        sb.append(" <");
        for (TypeVariable<Method> t : types) {
            sj.add(t.getName());
        }
        sb.append(sj.toString());
        sb.append("> ");
        Type returnType = m.getGenericReturnType();
        sb.append(returnType.getTypeName()).append(" ");
        sb.append(m.getName());
        sb.append("(");
        sj = new StringJoiner(", ");
        Type[] paramTypes = m.getGenericParameterTypes();
        for (Type t : paramTypes) {
            sj.add(t.getTypeName());
        }
        sb.append(sj.toString());
        sb.append(")");
        return sb.toString();
    }
}

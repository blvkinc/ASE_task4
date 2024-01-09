package reflection_api;
import java.lang.reflect.Method;

/**
 * Returns the types of all methods in the Simple class.
 */
public class Reflection12 {
    public static void main(String[] args) {
        Simple s = new Simple();
        Class<?> c = s.getClass();

        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            System.out.printf("%s %s", m.getReturnType().getSimpleName(), m.getName());
            System.out.println();
        }
    }
}

package reflection_api;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Modifier;

/**
 * This code demonstrates retrieving the modifier of a method as a String
 * (e.g., public, private) within the Simple class.
 */
public class Reflection15 {
    public static void main(String[] args) {
        Simple s = new Simple();
        Class<?> c = s.getClass();

        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            System.out.printf("%s ", Modifier.toString(m.getModifiers()));
            System.out.printf("%s %s(", m.getReturnType().getSimpleName(), m.getName());
            int count = 0;
            for (Parameter p : m.getParameters()) {
                if (count != 0) {
                    System.out.print(", ");
                }
                System.out.printf("%s %s", p.getType().getSimpleName(), p.getName());
                count++;
            }
            System.out.println(")");
        }
    }
}

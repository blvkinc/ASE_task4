package reflection_api;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Modifier;

/**
 * This code demonstrates retrieving the modifier of a method as integer code
 */
public class Reflection14 {
    public static void main(String[] args) {
        Simple s = new Simple();
        Class<?> c = s.getClass();

        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            System.out.printf("%d ", m.getModifiers());
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

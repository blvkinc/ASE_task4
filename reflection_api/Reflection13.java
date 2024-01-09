package reflection_api;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * This code prints all method names along with parameter names and types of the Simple class.
 */
public class Reflection13 {
    public static void main(String[] args) {
        Simple s = new Simple();
        Class<?> c = s.getClass();

        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
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

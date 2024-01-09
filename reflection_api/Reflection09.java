package reflection_api;

import java.lang.reflect.Method;

/**
 * This experiment demonstrates accessing and displaying methods of the Simple class
 * using Java's reflection API. It shows that reflection allows retrieval of method
 * names and parameter types, including both public and inherited methods.
 */
public class Reflection09 {
    public static void main(String[] args) throws Exception {
        Simple s = new Simple();
        Method[] methods = s.getClass().getDeclaredMethods();
        System.out.printf("There are %d methods\n", methods.length);

        for (Method m : methods) {
            m.setAccessible(true); // Allowing access to private methods
            System.out.printf("method name=%s type=%s parameters = ", m.getName(),
                    m.getReturnType().getSimpleName());
            Class<?>[] types = m.getParameterTypes();
            for (Class<?> c : types) {
                System.out.print(c.getName() + " ");
            }
            System.out.println();
        }
    }
}

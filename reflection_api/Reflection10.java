package reflection_api;

import java.lang.reflect.Method;

/**
 * This experiment demonstrates breaking encapsulation by invoking a private method
 * of the Simple class using Java's reflection API. It showcases how reflection
 * allows access to and invocation of otherwise inaccessible methods.
 */
public class Reflection10 {
    public static void main(String[] args) throws Exception {
        Simple s = new Simple();
        Method m = s.getClass().getDeclaredMethod("setA", String.class);
        m.setAccessible(true);
        m.invoke(s, "APPLE!");
        System.out.println(s);
    }
}

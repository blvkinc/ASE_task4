package reflection_api;

import java.lang.reflect.Method;

/**
 creates an AnnotatedSimple class instance. uses the implicit toString method to print the class.
 the class name is printed. prints every method name that has been declared in the class.
 */
public class Reflection11 {
    public static void main(String[] args) {
        Simple s = new Simple();
        Class<?> c = s.getClass();

        System.out.println("class = " + c);
        System.out.println("class name = " + c.getName());

        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            System.out.printf("%s", m.getName());
            System.out.println();
        }
    }
}

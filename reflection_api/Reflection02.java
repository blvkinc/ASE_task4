package reflection_api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/******************************************************************************
 * This experiment demonstrates the use of access modifiers in Java. They are
 * Java's way of implementing data hiding and restricting which methods are
 * accessible outside the class.
 * 
 * If you were to remove the comments this code would try to access the private
 * members setA and b. The compiler will complain about this.
 * 
 ******************************************************************************/

public class Reflection02 {
    public static void main(String[] args) {
        Simple s = new Simple();
        s.concatenateA("_World");

        // Using Reflection to access private methods
        try {
            Method concatenateBMethod = Simple.class.getDeclaredMethod("concatenateB", String.class);
            concatenateBMethod.setAccessible(true);
            concatenateBMethod.invoke(s, "_Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Using Reflection to access private fields
        try {
            Field bField = Simple.class.getDeclaredField("b");
            bField.setAccessible(true);
            String b = (String) bField.get(s);
            System.out.println("Value of b (private field): " + b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String a = s.a;
        System.out.println("Value of a (public field): " + a);

        System.out.println("s=" + s);
    }
}

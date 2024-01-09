package reflection_api;


import java.lang.reflect.Field;

/**
 * This experiment demonstrates accessing and displaying private String fields
 * of the Simple class using Java's reflection API. It showcases how reflection
 * allows access to private fields that would typically not be directly
 * accessible, thereby revealing their names, types, and values.
 */

public class Reflection07 {
    public static void main(String[] args) throws Exception {
        Simple s = new Simple();
        Field[] fields = s.getClass().getDeclaredFields();
        System.out.printf("There are %d fields\n", fields.length);

        for (Field f : fields) {
            f.setAccessible(true); // Allowing access to private fields
            if (f.getType() == String.class) {
                System.out.printf("field name=%s type=%s value=%s\n", f.getName(),
                        f.getType(), f.get(s));
            }
        }
    }
}

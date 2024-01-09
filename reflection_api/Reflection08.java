package reflection_api;

import reflection_api.Simple;
import java.lang.reflect.Field;

/**
 * This experiment demonstrates the ability to access and modify private String fields
 * of the Simple class using Java's reflection API. It showcases that not only
 * can the values of private String fields be accessed, but they can also be altered.
 */
public class Reflection08 {
    public static void main(String[] args) throws Exception {
        Simple s = new Simple();
        Field[] fields = s.getClass().getDeclaredFields();
        System.out.printf("There are %d fields\n", fields.length);

        for (Field f : fields) {
            f.setAccessible(true);

            if (f.getType() == String.class) {
                String fieldValue = (String) f.get(s);
                fieldValue += "_modified"; // Modify the string value by appending "_modified"
                f.set(s, fieldValue);

                System.out.printf("field name=%s type=%s value=%s\n", f.getName(),
                        f.getType(), f.get(s));
            } else {
                // Skip fields that are not of type String
                System.out.printf("Skipping field name=%s type=%s\n", f.getName(), f.getType());
            }
        }
    }
}

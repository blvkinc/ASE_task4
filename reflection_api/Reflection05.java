package reflection_api;

import java.lang.reflect.Field;

/******************************************************************************
 * In this experiment a different method is used to retrieve the fields. This
 * time a reference to the b field is obtained, but when it is used, a runtime
 * exception is thrown that clearly states that members with private modifiers
 * cannot be accessed. Again data integrity stands firm.
 * 
 ******************************************************************************/

public class Reflection05 {
    public static void main(String[] args) throws Exception {
        Simple s = new Simple();
        Field[] fields = s.getClass().getDeclaredFields();
        System.out.printf("There are %d fields\n", fields.length);

        for (Field f : fields) {
            if (f.getType() == String.class) {
                if (f.getName().equals("b")) {
                    try {
                        System.out.printf("field name=%s type=%s\n", f.getName(),
                                f.getType());
                        f.get(s); // Access private field without setting accessibility
                    } catch (IllegalAccessException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                } else {
                    
                    System.out.printf("field name=%s type=%s value=%s\n", f.getName(),
                            f.getType(), f.get(s));
                }
            }
        }
    }
}

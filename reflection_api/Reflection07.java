package reflection_api;


import java.lang.reflect.Field;

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

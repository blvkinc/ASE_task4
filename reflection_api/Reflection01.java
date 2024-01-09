package reflection_api;

import java.lang.reflect.Field;

/******************************************************************************
 * This experiment uses reflection to access and print the field values of a
 * Simple instance, showcasing how reflection works with String data types.
 * 
 ******************************************************************************/

public class Reflection01 {
    public static void main(String[] args) {
        Simple s = new Simple(); // Create an instance of Simple

        // Get the class of Simple
        Class<?> simpleClass = s.getClass();

        // Retrieve fields and print their values
        Field[] fields = simpleClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Override access restrictions
            try {
                System.out.println(field.getName() + "=" + field.get(s));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

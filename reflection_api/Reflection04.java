package reflection_api;

import java.lang.reflect.Field;

/******************************************************************************
 * This experiment demonstrates retrieving the fields of a Simple object using
 * reflection. It obtains a collection of Fields belonging to the Simple class.
 * Fields are another name for instance variables.
 * 
 * When this code is run, it prints details of a single field, a String called
 * "a" with the value "Hello". The private access modifier has prevented details
 * of the field "b" from being revealed. This showcases Java's data hiding
 * feature, maintaining data integrity.
 * 
 ******************************************************************************/

public class Reflection04 {
    public static void main(String[] args) throws Exception {
        Simple s = new Simple();
        Field[] fields = s.getClass().getDeclaredFields();
        System.out.printf("There are %d fields\n", fields.length);
        for (Field f : fields) {
            f.setAccessible(true); // Override access restrictions
            if (f.getType() == String.class) {
                System.out.printf("field name=%s type=%s value=%s\n", f.getName(),
                        f.getType(), f.get(s));
            }
        }
    }
}

package tests;

import reflection_api.Simple;

/******************************************************************************
 * This code demonstrates the use of the improved unit testing framework.
 ******************************************************************************/

public class SimpleTests {

    public void checkConstructorAndAccess() {
        Simple s = new Simple("Hello", "World");
        SimpleUnitTestFramework.assertEquals(s.getA(), "Hello");
        SimpleUnitTestFramework.assertEquals(s.getB(), "World");
        SimpleUnitTestFramework.assertNotEquals(s.getB(), "Hello");
        SimpleUnitTestFramework.assertNotEquals(s.getB(), "Different");
    }

    public void checkConcatenateA() {
        Simple s = new Simple("Hello", "World");
        s.concatenateA(", Universe!");
        SimpleUnitTestFramework.assertEquals(s.getA(), "Hello, Universe!");
    }

    public void assertPrivateConcatenateB() {
        Simple s = new Simple("Hello", "World");
        SimpleUnitTestFramework.invokePrivateMethod(s, "concatenateB", " from Reflection!");
        SimpleUnitTestFramework.assertEquals(s.getB(), "World from Reflection!");
    }

    public void assertPrivateFieldExample() {
        Simple s = new Simple("Hello", "World");
        SimpleUnitTestFramework.assertPrivateField(s, "b", "Modified");
    }

    public static void main(String[] args) {
        SimpleUnitTestFramework.runChecks(new SimpleTests());
        SimpleUnitTestFramework.report();
    }
}

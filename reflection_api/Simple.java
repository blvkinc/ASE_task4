package reflection_api;

//This class is used to demonstrate various aspects of Java reflection. 

public class Simple {

    public String a = "Hello";
    private String b = "World";

    public Simple() {
    }

    public Simple(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public void concatenateA(String str) {
        this.a += str;
    }

    private void concatenateB(String str) {
        this.b += str;
    }

    public String getA() {
        return a;
    }

    private void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String toString() {
        return String.format("(a:%s, b:%s)", a, b);
    }
}

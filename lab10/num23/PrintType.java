package lab10.num23;

public class PrintType {
    public static <T> void printType(T obj) {
        if (obj != null) {
            System.out.println(obj.getClass().getName());
        } else {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        printType(123);
        printType("Hello");
        printType(null);
    }
}

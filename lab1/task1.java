package lab1;

public class task1 {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            System.out.print(i);

            if (i % 10 != 0) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}

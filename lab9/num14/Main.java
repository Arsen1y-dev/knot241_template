package lab9.num14;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        Scanner scanner = new Scanner(System.in);
        String currentLight = scanner.nextLine().toUpperCase();

        TrafficLight light;
        try {
            light = TrafficLight.valueOf(currentLight);
            TrafficLight nextLight = light.getNextLight();
            System.out.println("Следующий сигнал: " + nextLight);
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильный ввод.");
        }

        scanner.close();
    }
}

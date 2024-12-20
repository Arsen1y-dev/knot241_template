package lab10.num20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public double sum() {
        double total = 0;
        for (T item : items) {
            total += item.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println((int) integerBox.sum()); // 30

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println(doubleBox.sum()); // 4.0
    }
}

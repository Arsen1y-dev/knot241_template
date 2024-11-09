package lab5.num8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ShopItem[] items = TestDataGenerator.generateTestData(100);

        // Сортировка по имени
        Arrays.sort(items, Comparator.comparing(ShopItem::getName));

        // Вывод в консоль
        for (ShopItem item : items) {
            System.out.println(item);
        }

        // Подсчет одинаковых элементов
        Map<ShopItem, Integer> counts = new HashMap<>();
        for (ShopItem item : items) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        System.out.println("\nКоличество одинаковых ShopItem:");
        for (Map.Entry<ShopItem, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
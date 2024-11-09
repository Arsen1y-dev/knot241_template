package lab5.num8;

import java.util.Random;

public class TestDataGenerator {

    public static ShopItem[] generateTestData(int numItems) {
        String[] names = {"книга", "ручка", "линейка", "пинал", "тетрадь", "ластик", "карандаш", "циркуль"};
        Random random = new Random();

        ShopItem[] items = new ShopItem[numItems];
        for (int i = 0; i < numItems; i++) {
            String name = names[random.nextInt(names.length)];
            double price = random.nextDouble() * 90 + 10;  // Цена от 10 до 100
            int quantity = random.nextInt(10) + 1;      // Количество от 1 до 10

            items[i] = new ShopItem(name, price, quantity);

            // Добавление некоторых одинаковых элементов (для теста)
            if (i % 10 == 0) {
                items[i] = new ShopItem("ручка", 2.5, 5);
            }
            if (i % 17 == 0) {
                items[i] = new ShopItem("книга", 25, 2);
            }
        }

        return items;
    }
}
package lab8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Добро пожаловать в систему управления пользователями!");

        try {
            users = UserManager.loadUsers();
            System.out.println("Список пользователей успешно загружен.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл данных отсутствует. Начинаем с пустого списка.");
        }

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Сохранить список пользователей в файл");
            System.out.println("4. Загрузить список пользователей из файла");
            System.out.println("5. Выйти");

            System.out.print("Введите номер действия: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addUser(scanner);
                    break;
                case "2":
                    showUsers();
                    break;
                case "3":
                    saveUsers();
                    break;
                case "4":
                    loadUsers();
                    break;
                case "5":
                    running = false;
                    saveUsersOnExit();
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }

        System.out.println("Программа завершена. До свидания!");
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Некорректный email. Пользователь не добавлен.");
            return;
        }

        users.add(new User(name, age, email));
        System.out.println("Пользователь добавлен.");
    }

    private static void showUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i));
            }
        }
    }

    private static void saveUsers() {
        try {
            UserManager.saveUsers(users);
            System.out.println("Список успешно сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла: " + e.getMessage());
        }
    }

    private static void loadUsers() {
        try {
            users = UserManager.loadUsers();
            System.out.println("Список успешно загружен из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки файла: " + e.getMessage());
        }
    }

    private static void saveUsersOnExit() {
        try {
            UserManager.saveUsers(users);
            System.out.println("Данные сохранены перед выходом.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения при выходе: " + e.getMessage());
        }
    }
}

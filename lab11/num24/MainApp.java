package lab11.num24;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(new UserDAOImpl());

        while (true) {
            System.out.print("Введите команду: ");
            String commandLine = scanner.nextLine();
            String[] commandParts = commandLine.split(" ");

            switch (commandParts[0]) {
                case "add":
                    try {
                        userService.registerUser(commandParts[1], commandParts[2]);
                        System.out.println("Пользователь добавлен.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "list":
                    try {
                        for (User user : userService.listAllUsers()) {
                            System.out.println(user);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case "delete":
                    try {
                        userService.deleteUser(Integer.parseInt(commandParts[1]));
                        System.out.println("Пользователь удалён.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "update":
                    try {
                        userService.updateUser(Integer.parseInt(commandParts[1]), commandParts[2], commandParts[3]);
                        System.out.println("Пользователь обновлён.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }
}

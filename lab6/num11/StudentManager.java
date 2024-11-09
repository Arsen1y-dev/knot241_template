package lab6.num11;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentManager {
    private final TreeSet<String> students = new TreeSet<>();
    private final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.run();
    }

    public void run() {
        while (true) {
            Menu.printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        listStudents();
                        break;
                    case 4:
                        findStudent();
                        break;
                    case 5:
                        findStudentsInRange();
                        break;
                    case 6:
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }

    private void addStudent() {
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();
        if (students.add(name)) {
            System.out.println("Студент добавлен.");
        } else {
            System.out.println("Студент с таким именем уже существует.");
        }
    }

    private void removeStudent() {
        System.out.print("Введите имя студента для удаления: ");
        String nameToRemove = scanner.nextLine();
        if (students.remove(nameToRemove)) {
            System.out.println("Студент удален.");
        } else {
            System.out.println("Студент не найден.");
        }
    }

    private void listStudents() {
        System.out.println("Список студентов:");
        students.forEach(System.out::println);
    }

    private void findStudent() {
        System.out.print("Введите имя студента для поиска: ");
        String nameToFind = scanner.nextLine();
        if (students.contains(nameToFind)) {
            System.out.println("Студент найден.");
        } else {
            System.out.println("Студент не найден.");
        }
    }

    private void findStudentsInRange() {
        System.out.print("Введите первого студента из списка (начало диапазона): ");
        String startRange = scanner.nextLine();
        System.out.print("Введите второго студента из списка (конец диапазона): ");
        String endRange = scanner.nextLine();

        System.out.println("Список студентов в диапазоне:");
        students.subSet(startRange, true, endRange, true).forEach(System.out::println);
    }
}
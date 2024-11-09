package lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race humanRace = new HumanRace();
        Race orcRace = new OrcRace();

        // Создаем персонажей
        Warrior warrior = new Warrior("Орк", orcRace);
        Mage mage = new Mage("Гендальф", humanRace);
        Priest priest = new Priest("Целитель", humanRace);

        System.out.println("Добро пожаловать в игру!");
        System.out.println("Персонажи:");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);

        boolean gameActive = true;

        // Игровой цикл
        while (gameActive) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Орк атакует");
            System.out.println("2. Гендальф кастует заклинание");
            System.out.println("3. Целитель лечит");
            System.out.println("4. Переместить персонажа");
            System.out.println("5. Показать статус всех персонажей");
            System.out.println("6. Выйти из игры");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (warrior.isAlive) {
                        System.out.println("Кого атаковать? 1 - Гендальф, 2 - Целитель");
                        int targetChoice = scanner.nextInt();
                        Player target = (targetChoice == 1) ? mage : priest;
                        warrior.attack(target);
                    } else {
                        System.out.println("Орк мёртв и не может атаковать.");
                    }
                    break;

                case 2:
                    if (mage.isAlive) {
                        System.out.println("На кого кастовать заклинание? 1 - Орк, 2 - Целитель");
                        int targetChoice = scanner.nextInt();
                        Player target = (targetChoice == 1) ? warrior : priest;
                        mage.castSpell(target);
                    } else {
                        System.out.println("Гендальф мёртв и не может кастовать.");
                    }
                    break;

                case 3:
                    if (priest.isAlive) {
                        System.out.println("Кого лечить? 1 - Орк, 2 - Гендальф");
                        int targetChoice = scanner.nextInt();
                        Player target = (targetChoice == 1) ? warrior : mage;
                        priest.heal(target);
                    } else {
                        System.out.println("Целитель мёртв и не может лечить.");
                    }
                    break;

                case 4:
                    System.out.println("Кого переместить? 1 - Орк, 2 - Гендальф, 3 - Целитель");
                    int moveChoice = scanner.nextInt();
                    Player playerToMove = (moveChoice == 1) ? warrior : (moveChoice == 2) ? mage : priest;

                    // Проверка, жив ли персонаж, перед перемещением
                    if (playerToMove.isAlive) {
                        System.out.println("Введите новую позицию X:");
                        int x = scanner.nextInt();
                        System.out.println("Введите новую позицию Y:");
                        int y = scanner.nextInt();
                        playerToMove.move(x, y);
                    } else {
                        System.out.println(playerToMove.getName() + " мёртв и не может быть перемещён.");
                    }
                    break;

                case 5:
                    System.out.println("\nСтатус всех персонажей:");
                    System.out.println(warrior);
                    System.out.println(mage);
                    System.out.println(priest);
                    break;

                case 6:
                    System.out.println("Выход из игры. Спасибо за игру!");
                    gameActive = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите действие от 1 до 6.");
                    break;
            }

            // Проверяем, если все мертвы, завершить игру
            if (!warrior.isAlive && !mage.isAlive && !priest.isAlive) {
                System.out.println("Все персонажи мертвы. Игра окончена.");
                gameActive = false;
            }
        }
        scanner.close();
    }
}
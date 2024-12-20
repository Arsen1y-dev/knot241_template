package lab6.num10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();

        System.out.println("Добро пожаловать в игру 'Виселица'!");

        do {
            game.play(scanner);
            System.out.println("Хотите сыграть снова? (да/нет)");
        } while (scanner.nextLine().equalsIgnoreCase("да"));

        System.out.println("Спасибо за игру!");
        scanner.close();
    }
}

package lab6.num10;

import java.util.Scanner;

public class HangmanGame {
    private static final int MAX_ATTEMPTS = 6;
    private final WordDictionary dictionary = new WordDictionary();

    public void play(Scanner scanner) {
        String word = dictionary.getRandomWord();
        GameState gameState = new GameState(word, MAX_ATTEMPTS);

        while (!gameState.isGameOver()) {
            System.out.println("Загаданное слово: " + gameState.getCurrentState());
            System.out.println("Осталось попыток: " + gameState.getAttemptsLeft());
            System.out.print("Введите букву: ");
            char letter = scanner.nextLine().toLowerCase().charAt(0);

            if (!gameState.guessLetter(letter)) {
                System.out.println("Вы уже вводили эту букву.");
                continue;
            }

            if (gameState.isLetterInWord(letter)) {
                if (gameState.isWordGuessed()) {
                    System.out.println("Поздравляем! Вы угадали слово: " + word);
                    break;
                }
            } else {
                System.out.println("Неверно! Осталось попыток: " + gameState.getAttemptsLeft());
            }
        }

        if (!gameState.isWordGuessed()) {
            System.out.println("Вы проиграли! Загаданное слово было: " + word);
        }
    }
}

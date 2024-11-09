package lab5.num9;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        WordProvider wordProvider = new WordProvider();
        List<String> words = wordProvider.getWords("/Users/arseniy/Documents/GitHub/knot241_template/lab4/dictionary.txt");
        if (words.isEmpty()) {
            System.out.println("Файл со словами не найден или пуст.");
            return;
        }

        Random random = new Random();
        Scanner inputScanner = new Scanner(System.in);

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60000;

        int correctWords = 0;
        int totalWords = 0;
        int totalChars = 0;
        long wordStartTime = 0;


        while (true) {
            wordStartTime = System.currentTimeMillis(); // Засекаем время начала ввода слова

            if (wordStartTime >= endTime) { // Если время вышло ДО начала ввода слова, выходим из цикла
                break;
            }

            String currentWord = words.get(random.nextInt(words.size()));
            System.out.print(currentWord + ": ");

            String userWord = inputScanner.next();

            if (System.currentTimeMillis() < endTime) { // Проверяем время ПОСЛЕ ввода слова
                totalWords++;
                totalChars += userWord.length();

                if (userWord.equals(currentWord)) {
                    correctWords++;
                }
            } else {
                break; // Если время вышло ПОСЛЕ ввода слова, выходим, не учитывая это слово
            }
        }


        inputScanner.close();

        System.out.println("\nВремя вышло!");
        System.out.println("Всего слов: " + totalWords);
        System.out.println("Правильных слов: " + correctWords);
        System.out.println("Всего введенных символов: " + totalChars);

        double charsPerSecond = (double) totalChars / 60;
        System.out.printf("Скорость ввода: %.2f символов в секунду\n", charsPerSecond);
    }
}
package lab4;

import java.io.FileNotFoundException;
import java.util.*;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize;
    private int polindrom;
    private int maxWordLength;
    private int minWordLength;
    private char[] alphabet;
    private int[] frequency;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;
        this.frequency = new int[alphabet.length];
        calculateStats();
    }

    private void calculateStats() {
        minWordLength = Integer.MAX_VALUE;
        maxWordLength = 0;
        for (String word : words) {
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
            if (word.length() < minWordLength) {
                minWordLength = word.length();
            }

            if (WordUtils.isPalindrome(word)) {
                polindrom++;
            }

            for (char c : word.toCharArray()) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (c == alphabet[i]) {
                        frequency[i]++;
                        break;
                    }
                }
            }
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(dictionarySize)];
    }

    public void printSymbolsStat() {
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }

    public List<String> findWordsFromLetters(String inputWord) {
        List<String> matchingWords = new ArrayList<>();
        char[] inputChars = inputWord.toLowerCase().toCharArray();
        Arrays.sort(inputChars);

        for (String dictionaryWord : words) {
            char[] dictionaryChars = dictionaryWord.toLowerCase().toCharArray();
            Arrays.sort(dictionaryChars);

            if (WordUtils.isSubset(dictionaryChars, inputChars)) {
                matchingWords.add(dictionaryWord);
            }
        }
        Collections.sort(matchingWords);
        return matchingWords;
    }

    public void printMatchingWordsStats(List<String> matchingWords) {
        if (matchingWords.isEmpty()) {
            return;
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        int palindromeCount = 0;

        for (String word : matchingWords) {
            int length = word.length();
            minLength = Math.min(minLength, length);
            maxLength = Math.max(maxLength, length);
            if (WordUtils.isPalindrome(word)) {
                palindromeCount++;
            }
        }

        System.out.println("Статистика найденных слов:");
        System.out.println("Минимальная длина: " + minLength);
        System.out.println("Максимальная длина: " + maxLength);
        System.out.println("Количество палиндромов: " + palindromeCount);
    }


    public static void main(String[] args) throws FileNotFoundException {
        char[] russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        String[] dictionaryWords = DictionaryReader.readDictionary("dictionary.txt");

        DictionaryStatistic stats = new DictionaryStatistic(dictionaryWords, russianAlphabet);

        System.out.println("Случайное слово: " + stats.getRandomWord());

        System.out.println("\nЧастота букв в словаре:");
        stats.printSymbolsStat();

        Scanner inputScanner = new Scanner(System.in, "UTF-8");

        while (true) {
            System.out.println("\nВведите слово (или 'q' для выхода):");
            String inputWord = inputScanner.nextLine();

            if (inputWord.equalsIgnoreCase("q")) {
                break;
            }

            List<String> matchingWords = stats.findWordsFromLetters(inputWord);

            System.out.println("\nВозможные слова:");
            if (matchingWords.isEmpty()) {
                System.out.println("Подходящих слов не найдено.");
            } else {
                for (String word : matchingWords) {
                    System.out.println(word);
                }
                stats.printMatchingWordsStats(matchingWords);
            }
        }
        inputScanner.close();
    }
}
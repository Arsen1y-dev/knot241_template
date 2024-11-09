package lab6.num10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordDictionary {
    private final List<String> words;
    private final Random random = new Random();

    public WordDictionary() {
        words = loadWordsFromFile("/Users/arseniy/Documents/GitHub/knot241_template/lab4/dictionary.txt");
    }

    private List<String> loadWordsFromFile(String fileName) {
        try {
            return Files.lines(Paths.get(fileName))
                    .filter(word -> word.length() >= 4)
                    .filter(word -> word.length() <= 7)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return List.of("абоба", "амогус");
        }
    }

    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}
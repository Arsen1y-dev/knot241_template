package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryReader {

    public static String[] readDictionary(String filePath) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("/Users/arseniy/Documents/GitHub/knot241_template/lab4/dictionary.txt"), "UTF-8");
        List<String> wordList = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            wordList.add(fileScanner.nextLine());
        }
        fileScanner.close();
        return wordList.toArray(new String[0]);
    }
}

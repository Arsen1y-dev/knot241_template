package lab4;

import java.util.Arrays;

public class WordUtils {

    public static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    public static boolean isSubset(char[] small, char[] big) {
        int i = 0;
        int j = 0;
        while (i < small.length && j < big.length) {
            if (small[i] == big[j]) {
                i++;
            }
            j++;
        }
        return i == small.length;
    }
}
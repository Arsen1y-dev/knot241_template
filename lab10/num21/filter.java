package lab10.num21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class filter {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered);
    }
}

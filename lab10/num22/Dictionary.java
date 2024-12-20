package lab10.num22;

import java.util.HashMap;
import java.util.Map;

public class Dictionary<K, V> {
    private Map<K, V> map = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        System.out.println(dictionary.get("Alice")); // 25
        dictionary.remove("Alice");
        System.out.println(dictionary.get("Alice")); // null
    }
}

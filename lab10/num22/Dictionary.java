package lab10.num22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {

    private List<Pair<K, V>> pairs;

    public Dictionary() {
        this.pairs = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                pair.setSecond(value);
                return;
            }
        }
        pairs.add(new Pair<>(key, value));
    }

    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        pairs.removeIf(pair -> pair.getKey().equals(key));
    }

    public boolean containsKey(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public List<Pair<K, V>> getAllPairs() {
        return new ArrayList<>(pairs);
    }

    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        dictionary.put("Martin", 22);

        System.out.println(dictionary.get("Alice")); // 25
        System.out.println(dictionary.containsKey("Bob")); // true

        dictionary.remove("Bob");

        System.out.println(dictionary.containsKey("Bob")); // false

        for (Pair<String, Integer> pair : dictionary.getAllPairs()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }
}
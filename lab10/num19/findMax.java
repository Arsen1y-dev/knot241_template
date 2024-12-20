package lab10.num19;

public class findMax {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("пу пу пу");
        }
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(findMax(numbers));

        String[] words = {"orange", "apple", "banana", "cherry"};
        System.out.println(findMax(words));
    }
}

package sorting;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            for (int j = 0; j < i; j++) {
                if (value < array[j]) {
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = value;
                    break;
                }
            }
        }
    }
}

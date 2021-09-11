package sorting;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIdx = j;
                }
            }
            System.arraycopy(array, i, array, i + 1, minIdx - i);
            array[i] = minValue;
        }
    }
}

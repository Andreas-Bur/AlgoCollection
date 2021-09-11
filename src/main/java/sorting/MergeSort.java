package sorting;

public class MergeSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(int[] array, int startIdx, int length) {
        if (length == 2) {
            if (array[startIdx] > array[startIdx + 1]) {
                int tmp = array[startIdx];
                array[startIdx] = array[startIdx + 1];
                array[startIdx + 1] = tmp;
            }
        } else if (length > 2) {
            int mid = length / 2;
            sort(array, startIdx, mid);
            sort(array, startIdx + mid, length - mid);
            int i = startIdx;
            int j = startIdx + mid;
            int left = startIdx + mid;
            while (i < left && j < startIdx + length) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    System.arraycopy(array, i, array, i + 1, j - i);
                    array[i] = tmp;
                    j++;
                    left++;
                }
                i++;
            }
        }
    }
}

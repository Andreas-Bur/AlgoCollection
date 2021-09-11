package sorting;

import java.util.Random;

public class Quicksort {
    public static void sort(int[] array, boolean randomized) {
        sort(array, randomized, 0, array.length);
    }

    private static void sort(int[] array, boolean randomized, int start, int length) {
        if (length <= 1) {
            return;
        }
        if (randomized) {
            Random random = new Random();
            int pivotIdx = start + random.nextInt(length);
            int tmp = array[start + length - 1];
            array[start + length - 1] = array[pivotIdx];
            array[pivotIdx] = tmp;
        }
        int left = start;
        int right = start + length - 1;
        int pivotIdx = start + length - 1;

        while (left != right) {
            while (array[left] <= array[pivotIdx] && left != right) {
                left++;
            }
            while (array[right] >= array[pivotIdx] && left != right) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }

        int tmp = array[right];
        array[right] = array[pivotIdx];
        array[pivotIdx] = tmp;

        sort(array, randomized, start, right - start);
        sort(array, randomized, right + 1, start + length - 1 - right);

    }
}

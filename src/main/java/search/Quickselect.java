package search;

import java.util.NoSuchElementException;
import java.util.Random;

public class Quickselect {
    public static int findElementAt(int[] array, int pos, boolean randomized) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        return findElementAt(arrayCopy, pos, randomized, 0, arrayCopy.length);
    }

    private static int findElementAt(int[] array, int index, boolean randomized, int start, int length) {
        if (length == 0) {
            throw new NoSuchElementException();
        } else if (length == 1) {
            return array[start];
        } else {
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

            if (index == right) {
                return array[right];
            } else if (index < right) {
                return findElementAt(array, index, randomized, start, right - start);
            } else {
                return findElementAt(array, index, randomized, right + 1, start + length - 1 - right);
            }
        }
    }
}

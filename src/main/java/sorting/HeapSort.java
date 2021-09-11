package sorting;

import datastructures.Heap;

public class HeapSort {
    public static void sort(int[] array) {
        Heap heap = new Heap(array);
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = heap.extractMax();
        }
    }
}

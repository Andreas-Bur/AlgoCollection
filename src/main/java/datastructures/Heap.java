package datastructures;

public class Heap {

    int[] array;
    int MAX_SIZE;
    int length = 0;

    public Heap(int size) {
        MAX_SIZE = size;
        array = new int[size];
    }

    public Heap(int[] array) {
        this.array = array;
        this.MAX_SIZE = array.length;
        this.length = array.length;
        for (int i = 1; i < array.length; i++) {
            heapifyAt(i);
        }
    }

    public void addValue(int value) {
        array[length] = value;
        length++;
        heapifyAt(length);
    }

    public int extractMax() {
        int max = array[0];
        array[0] = array[length - 1];
        length--;
        repair();
        return max;
    }

    private void repair() {
        int pos = 0;
        while (2 * pos + 1 < length) {
            if (2 * pos + 2 < length && array[2 * pos + 2] > array[2 * pos + 1]) {
                if (array[2 * pos + 2] > array[pos]) {
                    int tmp = array[2 * pos + 2];
                    array[2 * pos + 2] = array[pos];
                    array[pos] = tmp;
                    pos = 2 * pos + 2;
                } else {
                    return;
                }
            } else if (array[2 * pos + 1] > array[pos]) {
                int tmp = array[2 * pos + 1];
                array[2 * pos + 1] = array[pos];
                array[pos] = tmp;
                pos = 2 * pos + 1;
            } else {
                return;
            }
        }
    }

    private void heapifyAt(int pos) {
        if (length >= 2) {
            int parent = (pos - 1) / 2;

            while (pos != parent && array[pos] > array[parent]) {
                int tmp = array[parent];
                array[parent] = array[pos];
                array[pos] = tmp;

                pos = parent;
                parent = (pos - 1) / 2;
            }
        }
    }
}

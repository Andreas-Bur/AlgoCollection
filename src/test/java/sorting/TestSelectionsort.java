package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestSelectionsort {

    @Test
    void testSelectionsortPrimitiveRandomLarge() {
        int SIZE = 10000;
        int[] controlArray = new int[SIZE];
        int[] testArray = new int[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            controlArray[i] = r.nextInt();
            testArray[i] = controlArray[i];
        }

        SelectionSort.sort(testArray);
        Arrays.sort(controlArray);

        Assertions.assertArrayEquals(controlArray, testArray);
    }
}

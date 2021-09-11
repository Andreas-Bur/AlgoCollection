package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestQuickselect {
    @Test
    void testQuickselectRandomizedRandomLarge() {
        int SIZE = 10000;
        int[] controlArray = new int[SIZE];
        int[] testArray = new int[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            controlArray[i] = r.nextInt();
            testArray[i] = controlArray[i];
        }
        Arrays.sort(controlArray);

        for (int i = 0; i < 100; i++) {
            int pos = r.nextInt(SIZE);
            int result = Quickselect.findElementAt(testArray, pos, true);
            Assertions.assertEquals(controlArray[pos], result);
        }
    }

    @Test
    void testQuickselectRandomLarge() {
        int SIZE = 10000;
        int[] controlArray = new int[SIZE];
        int[] testArray = new int[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            controlArray[i] = r.nextInt();
            testArray[i] = controlArray[i];
        }
        Arrays.sort(controlArray);

        for (int i = 0; i < 100; i++) {
            int pos = r.nextInt(SIZE);
            int result = Quickselect.findElementAt(testArray, pos, false);
            Assertions.assertEquals(controlArray[pos], result);
        }
    }
}

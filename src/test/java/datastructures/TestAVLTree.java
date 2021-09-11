package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class TestAVLTree {
    @Test
    void testAVLTreeRandomLarge() {
        int SIZE = 10000;
        int[] controlArray = ThreadLocalRandom.current().ints(0, Integer.MAX_VALUE).distinct().limit(SIZE).toArray();
        AVLTree avlTree = new AVLTree();
        for (int j : controlArray) {
            avlTree.insert(j);
        }

        Arrays.sort(controlArray);
        int[] array2 = avlTree.toArray();

        Assertions.assertArrayEquals(controlArray, array2);
    }
}

package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MedianOfKSortedArraysTests {
    private MedianOfKSortedArrays medianOfKSortedArrays;

    @Before
    public void setup() {
        medianOfKSortedArrays = new MedianOfKSortedArrays();
    }
    @Test
    public void testCountSmaller() {
        assertEquals(2, medianOfKSortedArrays.countSE(new int[]{1, 2, 3}, 2));
        assertEquals(0, medianOfKSortedArrays.countSE(new int[]{}, 1));
    }

    @Test
    public void testFindMedian() {
        int[] row0 = {1};
        int[] row1 = {2};
        int[] row2 = {3};
        int[][] matrix = new int[3][];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;

        assertEquals(2, medianOfKSortedArrays.findMedian(matrix), 0.1);

        int[] row3 = {3};
        matrix = new int[4][];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;
        matrix[3] = row3;

        assertEquals(2.5, medianOfKSortedArrays.findMedian(matrix), 0.1);
    }

    @Test
    public void testFindKth() {
        int[] row0 = {1};
        int[] row1 = {2};
        int[] row2 = {3};
        int[][] matrix = new int[3][];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;

        assertEquals(2, medianOfKSortedArrays.findKth(matrix, 2, 1, 3));
        assertEquals(3, medianOfKSortedArrays.findKth(matrix, 3, 1, 3));

        int[] row3 = {3};
        matrix = new int[4][];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;
        matrix[3] = row3;
        assertEquals(2, medianOfKSortedArrays.findKth(matrix, 2, 1, 3));
        assertEquals(3, medianOfKSortedArrays.findKth(matrix, 3, 1, 3));

        row0 = new int[]{5,7,15,27,37,47,50,52,56,100};
        row1 = new int[]{29,62};
        row2 = new int[]{1,8,66};
        row3 = new int[]{2,5,37};
        int[] row4 = new int[]{25,60,80};
        int[] row5 = new int[]{48,54,61,69};
        int[] row6 = new int[]{19,28,34,50,53,55,66,76,94};
        matrix = new int[7][];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;
        matrix[3] = row3;
        matrix[4] = row4;
        matrix[5] = row5;
        matrix[6] = row6;

        assertEquals(48, medianOfKSortedArrays.findKth(matrix, 17, 1, 100));
        assertEquals(50, medianOfKSortedArrays.findKth(matrix, 18, 1, 100));
    }

    @Test
    public void testCountAllSmaller() {
        int[] row0 = {1};
        int[] row1 = {2};
        int[] row2 = {3};
        int[][] matrix = new int[3][];
        matrix[0] = row0;
        matrix[1] = row1;
        matrix[2] = row2;

        assertEquals(2, medianOfKSortedArrays.countAllSE(matrix, 2));
    }
}

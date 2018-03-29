package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/pancake-sorting/
 */
public class PancakeSorting {
    /**
     * Two Pointers
     *
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int j = array.length - 1;
        while (j > 0) {
            int index = j;
            for (int i = j; i >= 0; i--) {
                if (array[i] > array[index]) {
                    index = i;
                }
            }
            if (index < j) {
                FlipTool.flip(array, index);
                FlipTool.flip(array, j);
            }
            j--;
        }
    }
}

/**
 * Provided class and function
 */
class FlipTool {
    /**
     * Reverse array from 0 to i
     *
     * @param arr
     * @param i
     */
    static public void flip(int[] arr, int i) {
        int left = 0;
        int right = i;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
 }
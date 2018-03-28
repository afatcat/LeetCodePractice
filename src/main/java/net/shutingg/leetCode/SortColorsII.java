package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/sort-colors-ii/
 */
public class SortColorsII {
    /**
     * Quick Sort similar
     *
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length < k || k <= 0) {
            return;
        }

        sort(colors, 1, k, 0, colors.length - 1);
    }

    private void sort(int[] colors, int rangeLeft, int rangeRight, int st, int end) {
        if (st >= end) {
            return;
        }
        if (rangeLeft >= rangeRight) {
            return;
        }
        int pivot = (rangeLeft + rangeRight) / 2;
        int i = st;
        int j = end;
        while (i <= j) {
            while (i <= j && colors[i] <= pivot) { // match the next sort range
                i++;
            }

            while (i <= j && colors[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int tmp = colors[i];
                colors[i] = colors[j];
                colors[j] = tmp;
                i++;
                j--;
            }
        }

        sort(colors, rangeLeft, pivot, st, j);
        sort(colors, pivot + 1, rangeRight, i, end);
    }
}

package net.shutingg.leetCode;

import java.util.Random;

public class SortIntegersII {
    Random rand = new Random();
    /**
     * Quick Sort
     *
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2_2(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        quicksort(A, 0, A.length - 1);
    }

    private void quicksort(int[] A, int st, int end) {
        if (st >= end) {
            return;
        }
        int p = rand.nextInt(end - st + 1) + st;
        int pivot = A[p];
        int left = st;
        int right = end;
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
        quicksort(A, st, right);
        quicksort(A, left, end);
    }

    /**
     * Merge Sort
     *
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        int[] tmp = new int[A.length];
        mergeSort(A, 0, A.length - 1, tmp);
    }

    private void mergeSort(int[] A, int st, int end, int[] tmp) {
        if (st >= end) {
            return;
        }
        mergeSort(A, st, (st + end) / 2, tmp);
        mergeSort(A, (st + end) / 2 + 1, end, tmp);
        merge(A, st, (st + end) / 2, end, tmp);
    }

    private void merge(int[] A, int st, int mid, int end, int[] tmp) {
        int p1 = st;
        int p2 = mid + 1;
        int index = st;
        while (p1 <= mid && p2 <= end) {
            if (A[p1] < A[p2]) {
                tmp[index] = A[p1];
                p1++;
            } else {
                tmp[index] = A[p2];
                p2++;
            }
            index++;
        }
        while (p1 <= mid) {
            tmp[index] = A[p1];
            p1++;
            index++;
        }
        while (p2 <= end) {
            tmp[index] = A[p2];
            p2++;
            index++;
        }
        for (int i = st; i <= end; i++) {
            A[i] = tmp[i];
        }
    }
}

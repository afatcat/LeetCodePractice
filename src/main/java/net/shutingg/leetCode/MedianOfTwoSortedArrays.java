package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    /**
     * Binary Search
     *
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays2(int[] A, int[] B) {
        if (A == null && B == null) {
            return 0;
        }
        if (A == null) {
            if (B.length == 0) {
                return 0;
            }
            else if ((B.length & 1) == 1) {
                return B[B.length / 2 + 1];
            } else {
                return (B[B.length / 2] + B[B.length / 2 + 1]) / 2.0;
            }
        }
        if (B == null) {
            if (A.length == 0) {
                return 0;
            } else if ((A.length & 1) == 1) {
                return A[A.length / 2 + 1];
            } else {
                return (A[A.length /2] + A[A.length / 2 + 1]) / 2.0;
            }
        }
        int total = A.length + B.length;
        if ((total & 1) == 1) {
            return findKthLargest(A, B, total / 2 + 1);
        } else {
            int left = findKthLargest(A, B, total / 2);
            int right = findKthLargest(A, B, total / 2 + 1);
            System.out.println("left: " + left +", right: " + right);
            return (left + right) / 2.0;
        }
    }

    private int findKthLargest(int[] arr1, int[] arr2, int k) {
        if (arr1 == null && arr2 == null) {
            return 0;
        }
        if (arr1 == null || arr1.length == 0) {
            return arr2[arr2.length - k];
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1[arr1.length - k];
        }

        int min = Math.min(arr1[0], arr2[0]);
        int max = Math.max(arr1[arr1.length - 1], arr2[arr2.length - 1]);
        while (min + 1 < max) {
            int pivot = (max - min) / 2 + min;
            int count = countGEInTwo(arr1, arr2, pivot);
            if (count < k) {
                max = pivot;
            } else {
                min = pivot;
            }
        }

        System.out.println("min: " + min + ", max: " + max);
        if (countGEInTwo(arr1, arr2, max) >= k) {
            System.out.println("k: " + k + ", " + max);
            return max;
        } else {
            System.out.println("k: " + k + ", " + min);
            return min;
        }
    }

    private int countGEInTwo(int[] arr1, int[] arr2, int pivot) {
        return countGE(arr1, pivot) + countGE(arr2, pivot);
    }

    private int countGE(int[] arr, int pivot) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int st = 0;
        int end = arr.length - 1;
        while (st + 1 < end) {
            int mid = (end - st) / 2 + st;
            if (arr[mid] >= pivot) {
                end = mid;
            } else {
                st = mid;
            }
        }
        if (arr[st] >= pivot) {
            System.out.println(arr.length + " pivot: " + pivot + ", st: " + st);
            return arr.length - st;
        }
        if (arr[end] >= pivot) {
            System.out.println(arr.length + " pivot: " + pivot + ", end: " + end);
            return arr.length - end;
        }


        return 0;
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0 && n==0){
            return 0;
        }
        if(m < n){
            return findMedianSortedArrays(nums2, nums1);
        }
        if(n==0){
            return m%2==0 ? (nums1[m/2-1]+nums1[m/2]/2) : nums1[m/2];
        }
        if(nums1[m-1]<nums2[0]){
            if(m == n){
                return (nums1[m-1]+nums2[0])/2;
            }
            return (nums1[(m+n)/2]+nums1[(m+n+1)/2])/2;
        }
        if(nums1[0]>nums2[n-1]){
            if(m == n){
                return (nums1[0]+nums2[n-1])/2;
            }
            return (nums1[(m-n-1)/2]+nums1[(m-n)/2])/2;
        }
        int i1 = (m-1)/2;
        int i2 = m/2;
        int j1 = (m+n)/2 - i1 -1;
        int j2 = (m+n-3)/2 - i1;
        int left = 0;
        int right = m-1;
        while(true){
            if(nums1[i1]<=nums2[j2] && nums2[j1]<=nums1[i2]){
                int tmp1 = nums1[i1]<nums2[j1] ? nums2[j1] : nums1[i1];
                int tmp2 = nums1[i2]>nums2[j2] ? nums2[j2] : nums1[i2];
                return (tmp1+tmp2)/2;
            }else if(nums1[i1]>nums2[j2]){
                right = i1;
                i1 = (left+i1)/2;
                i2 = (left+i2)/2;
                j1 = (m+n)/2 - i1 -1;
                j2 = (m+n-3)/2 - i1;
            }else{
                left = i2;
                i1 = (i1+right+1)/2;
                i2 = (i2+right+1)/2;
                j1 = (m+n)/2 - i1 -1;
                j2 = (m+n-3)/2 - i1;
            }
        }
    }
}

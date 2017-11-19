package net.shutingg.leetCode;

public class MedianOfTwoSortedArrays {
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

package net.shutingg.leetCode;

public class LongestIncreasingSubsequence {
    /**
     * DP - O(N*logN)
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] b = new int[n+1];
        b[0] = Integer.MIN_VALUE;
        int btop = 0;
        int start, stop;

        for(int i = 0; i < n; i++){
            start = 0;
            stop = btop;
            int p = (start + stop) / 2;
            while(start <= stop){
                if(b[p] < nums[i]){
                    start = p+1;
                }else{
                    stop = p-1;
                }
                p = (start + stop) / 2;
            }
            b[p+1] = nums[i];
            if(p+1 > btop){
                btop++;
            }
        }

        return btop;
    }

    /**
     * DP - O(N^2)
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        //f[i] = 1 or min(f[j]+1 | nums[j-1]<nums[i-1])

        int n = nums.length;
        if(n == 0) return 0;
        int[] f = new int[n+1];
        int[] a = new int[n+1];
        f[0] = 0;
        a[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            f[i] = 1;
            for(int j = 1; j < i; j++){
                if(nums[j-1] < nums[i-1]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            res = Math.max(res, f[i]);
        }
        return res;
    }
}

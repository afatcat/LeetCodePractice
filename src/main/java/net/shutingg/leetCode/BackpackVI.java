package net.shutingg.leetCode;

/**
 * Difference with V: order of array matters.
 */
public class BackpackVI {
    /*
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int[] f = new int[target+1];
        f[0] = 1;
        for(int i=1; i<=target; i++){
            f[i] = 0;
            for(int j=0; j<n; j++){
                if(i-nums[j]>=0){
                    f[i]+=f[i-nums[j]];
                }
            }
        }
        return f[target];
    }
}

package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/jump-game/
 */
public class JumpGame {
    /**
     * Greedy
     * O(n)
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump2(int[] A) {
        int n = A.length;
        int p = 0;
        for(int i = 0; i <= p; i++){
            int np = A[i] + i;
            if(np >= n-1){
                return true;
            }
            if(np > p){
                p = np;
            }
        }
        return false;
    }

    /**
     * DP - coordinate
     * O(n^2)
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // f[j] = f[i] && i + A[i] >= j | 0 <= i < j
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(f[j] && j + A[j] >= i){
                    f[i] = true;
                    continue;
                }
            }
        }

        return f[n-1];
    }
}

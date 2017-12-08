package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/backpack/
 * http://www.jiuzhang.com/solutions/backpack/
 */
public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        boolean[][] f = new boolean[m+1][n+1];
        for(int i = 0; i <= n; i++){
            f[0][i] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                f[j][i] = f[j][i-1];
                if (j-A[i-1]>=0){
                    f[j][i] |= f[j-A[i-1]][i-1];
                }
            }
        }
        for(int i = m; i >=0; i--){
            if(f[i][n]){
                return i;
            }
        }
        return 0;
    }

    /**
     * Use rolling array to make space into O(m)
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPackWith2RowArray(int m, int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        boolean[][] f = new boolean[m+1][2];
        int row1 = 0;
        int row2 = 1;
        f[0][0] = true;
        f[0][1] = true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                f[j][row2] = f[j][row1];
                if (j-A[i-1]>=0){
                    f[j][row2] |= f[j-A[i-1]][row1];
                }
            }
            int tmp = row1;
            row1 = row2;
            row2 = tmp;
        }
        for(int i = m; i >=0; i--){
            if(f[i][row1]){
                return i;
            }
        }
        return 0;
    }
}

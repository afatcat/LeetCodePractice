package net.shutingg.leetCode;

public class KSum {
    /*
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        int[][][] f = new int[n+1][k+1][target+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k && j<=i; j++){
                for(int t=1; t<=target; t++){
                    f[i][j][t] = f[i-1][j][t];
                    if(t-A[i-1]>0){
                        f[i][j][t] += f[i-1][j-1][t-A[i-1]];
                    }else if(t-A[i-1]==0 && j==1){
                        f[i][j][t] += 1;
                    }
                }
            }
        }
        return f[n][k][target];
    }
}

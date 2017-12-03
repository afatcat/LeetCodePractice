package net.shutingg.leetCode;

public class PerfectSquares {
    public int numSquares(int n) {
        if(n<=0){
            return 0;
        }
        int[] res = new int[n+1];
        int root = 0;
        for(int i=1; i<=n; i++){
            res[i] = i;
            if(((root+1)*(root+1)) ==i){
                res[i] = 1;
                root++;
            }else{
                for(int j = 1; j <= root; j++){
                    res[i] = res[i] < res[i-j*j] + 1 ? res[i] : res[i-j*j] + 1;
                }
            }
        }
        return res[n];
    }
}

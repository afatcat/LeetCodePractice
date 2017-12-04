package net.shutingg.leetCode;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if(n == 0) return 0;
        int[] f = new int[n+1];

        boolean[][] isPal = new boolean[n][n];
        calPal(isPal, cs);

        //init
        f[0] = 0;

        //formula
        for(int i = 1; i<= n; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = i; j>=1; j--){
                if(isPal[j-1][i-1]){
                    f[i] = Math.min(f[i], f[j-1]+1);
                }
            }
        }

        return f[n]-1;
    }

    private void calPal(boolean[][] isPal, char[] cs){
        int n = cs.length;
        for(int mid = 0; mid < n; mid++){
            isPal[mid][mid] = true;
            //mid is middle
            int i=mid-1, j=mid+1;
            while(i>=0 && j<n && cs[i] == cs[j]){
                isPal[i][j] = true;
                i--;
                j++;
            }

            //gap before mid is middle
            i = mid-1;
            j = mid;
            while(i>=0 && j<n && cs[i] == cs[j]){
                isPal[i][j] = true;
                i--;
                j++;
            }
        }
    }
}

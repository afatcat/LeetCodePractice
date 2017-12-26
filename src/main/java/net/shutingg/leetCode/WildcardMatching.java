package net.shutingg.leetCode;

public class WildcardMatching {
    /*
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // f[i][j] = f[i-1][j-1] && (c1[i-1] == c2[j-1] || c2[j-1] == '?')
        // OR
        // f[i][j] = f[i-1][j] && c2[j-1] == '*'
        // OR
        // f[i][j] = f[i-1][j-1] && c2[j-1] == '*'
        // OR
        // f[i][j] = f[i][j-1] && c2[j-1] == '*'
        if(s == null || p == null){
            return false;
        }
        int m = s.length();
        int n = p.length();
        char[] c1 = s.toCharArray();
        char[] c2 = p.toCharArray();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int j = 0; j < n; j++){
            if(c2[j] == '*'){
                f[0][j+1] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(c2[j-1]!='*'){
                    f[i][j] = f[i-1][j-1] && (c1[i-1] == c2[j-1] || c2[j-1] == '?');
                }else{
                    f[i][j] = f[i-1][j] || f[i][j-1];
                }
            }
        }

        return f[m][n];
    }
}

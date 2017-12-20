package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/regular-expression-matching/
 */
public class RegularExpressionMatching {
    /**
     * DP - Duel Sequence
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }

        int m = s.length();
        int n = p.length();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        if(m != 0 && n == 0){
            return false;
        }

        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;

        for(int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(cp[j-1] == '.'){
                    if(i > 0){
                        f[i][j] = f[i-1][j-1];
                    }else{
                        f[i][j] = false;
                    }
                }else if(cp[j-1] != '*'){
                    if(i > 0){
                        f[i][j] = f[i-1][j-1] && cs[i-1] == cp[j-1];
                    }else{
                        f[i][j] = false;
                    }
                }else{
                    if(j-2 < 0){
                        //wrong pattern
                        f[i][j] = false;
                    }else{
                        f[i][j] = f[i][j-2];
                        if(i > 0 && (cs[i-1] == cp[j-2] || cp[j-2] == '.')){
                            f[i][j] |= f[i-1][j];
                        }
                    }
                }
            }
        }

        return f[m][n];
    }
}

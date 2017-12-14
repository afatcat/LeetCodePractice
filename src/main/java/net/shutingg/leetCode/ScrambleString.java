package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/scramble-string/
 */
public class ScrambleString {
    /*
     * DP - section
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2){
            return false;
        }
        if(n1 == 0){
            return true;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        if(n1 == 1){
            return c1[0] == c2[0];
        }

        boolean[][][] f = new boolean[n1][n1][n1+1];

        for(int len = 1; len <= n1; len++){
            for(int i = 0; i <= n1 - len; i++){
                for(int j = 0; j <= n1 - len; j++){
                    if(len == 1){
                        f[i][j][1] = c1[i] == c2[j];
                        continue;
                    }

                    for(int sec = 1; sec < len; sec++){
                        if(f[i][j][sec] && f[i+sec][j+sec][len-sec]){
                            f[i][j][len] = true;
                            break;
                        }

                        if(f[i][j+len-sec][sec] && f[i+sec][j][len-sec]){
                            f[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return f[0][0][n1];
    }
}

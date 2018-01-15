package net.shutingg.leetCode;

public class DecodeWaysII {
    /**
     * DP - helper method
     * @param s: a message being encoded
     * @return: an integer
     */
    public int numDecodings(String s) {
        // f[i] = f[i-1] * ways1 + f[i-2] * ways2 | A[i-2-1] = 1, 2, *

        if(s == null){
            return 0;
        }
        int mod =  1000000007;
        int n = s.length();
        long[] f = new long[n+1];
        f[0] = 1;
        char[] cs = s.toCharArray();

        for(int i = 1; i <= n; i++){
            f[i] = ways1(cs[i-1]) * f[i-1];
            if(i > 1){
                f[i] += ways2(cs[i-2], cs[i-1]) * f[i-2];
            }
            f[i] = f[i] % mod;
        }

        return (int) f[n];
    }

    private int ways1(char d){
        if(d == '0'){
            return 0;
        }else if(d != '*'){
            return 1;
        }else{
            return 9;
        }
    }

    private int ways2(char d1, char d2){
        if(d1 == '1'){
            if(d2 == '*'){
                return 9;
            }else{
                return 1;
            }
        }else if(d1 == '2'){
            if(d2 == '*'){
                return 6;
            }else if(d2 >= '0' && d2 <= '6'){
                return 1;
            }else{
                return 0;
            }
        }else if(d1 == '*'){
            if(d2 == '*'){
                return 15;
            }else if(d2 >= '0' && d2 <= '6'){
                return 2;
            }else{
                return 1;
            }
        }else{
            return 0;
        }
    }
}

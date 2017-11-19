package net.shutingg.leetCode;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null){
            if(s2 !=null){
                return s2.equals(s3);
            }else{
                return s3 == null;
            }
        }else{
            if(s2 == null){
                return s1.equals(s3);
            }
        }

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        boolean f[][] = new boolean[s1.length()+1][s2.length()+1];
        f[0][0] = true;
        for(int i=1; i<= s1.length(); i++){
            f[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for(int j=1; j<= s2.length(); j++){
            f[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }

        for(int i=1; i<= s1.length(); i++){
            for(int j=1; j<= s2.length(); j++){
                f[i][j] = f[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)
                        || f[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }

        return f[s1.length()][s2.length()];
    }
}

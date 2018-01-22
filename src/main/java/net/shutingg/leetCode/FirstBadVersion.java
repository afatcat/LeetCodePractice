package net.shutingg.leetCode;

public class FirstBadVersion {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int st = 1;
        int end = n;
        int p = st + (end - st) / 2; // instead of int p = (st + end) / 2 to prevent integer overflow
        while (st < end){
            if (SVNRepo.isBadVersion(p)) {
                end = p;
                p = st + (end - st) / 2;
            }else{
                st = p + 1;
                p = st + (end - st) / 2;
            }
        }

        return p;
    }
}

class SVNRepo{
    static int BAD_VERSION = 10;

    static boolean isBadVersion(int v){
        //some definition
        if(v >= BAD_VERSION){
            return true;
        }else{
            return false;
        }
    }
}

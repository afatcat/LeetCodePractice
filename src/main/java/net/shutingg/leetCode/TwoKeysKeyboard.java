package net.shutingg.leetCode;

/**
 * Created by sguan on 10/20/17.
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if(n<=1) return 0;
        for(int i=n/2;i>1;i--){
            if(n%i==0){
                return minSteps(i)+n/i;
            }
        }
        return n;
    }
}

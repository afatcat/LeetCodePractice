package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        generator(result, 0, n, "");
        return result;
    }

    private void generator(List<String> list, int leftCount, int rightCount, String str){
        if(rightCount > 0){
            if(leftCount > 0){
                generator(list, leftCount-1, rightCount, str+")");
            }
            generator(list, leftCount+1, rightCount-1, str+"(");
        }else if(leftCount >0){
            generator(list, leftCount-1, rightCount, str+")");
        }else{
            list.add(str);
        }
    }
}

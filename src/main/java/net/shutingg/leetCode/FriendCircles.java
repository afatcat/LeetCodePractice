package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FriendCircles {
    //12ms, beats 54.99%
    public int findCircleNum2(int[][] M) {
        if(M==null || M.length==0){
            return 0;
        }

        boolean[] friended = new boolean[M.length];
        int count = 1;
        friended[0]=true;
        digFriend(0, friended, M);
        for(int i=1; i<M.length; i++){
            if(!friended[i]){
                count++;
                digFriend(i, friended, M);
            }
        }

        return count;
    }

    private void digFriend(int i, boolean[] friended, int[][]M){
        for(int j=1; j<M.length; j++) {
            if (!friended[j]) {
                if(M[j][i]==1){
                    friended[j]=true;
                    digFriend(j, friended, M);
                }
            }
        }
    }



    //24 ms, beats 12.42%
    public int findCircleNum(int[][] M) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> included = new HashSet<>();
        int count = 0;

        for(int i=M.length-1; i>=0; i--) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int i = stack.pop();
            if(!included.contains(i)) {
                count++;
                included.add(i);
            }
            for(int j=0; j<=M.length-1; j++){
                if(M[i][j]==1 && i!=j){
                    if(!included.contains(j)){
                        included.add(j);
                        stack.push(j);
                    }
                }
            }
        }
        return count;
    }
}

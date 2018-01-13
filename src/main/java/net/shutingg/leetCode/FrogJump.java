package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    /*
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // {A[i], {j, k, l...}}
        // i: index, j, k, l: jump length that got to i

        int n = stones.length;
        if(n == 0){
            return true;
        }
        if(stones[0] != 0){
            return false;
        }

        //init
        Map<Integer, Set<Integer>> f = new HashMap<>();
        for(int i = 0; i < n; i++){
            f.put(stones[i], new HashSet());
        }
        f.get(stones[0]).add(0);

        for(int i = 0; i < n; i++){
            for(int j : f.get(stones[i])){
                for(int k = j-1; k <= j+1; k++){
                    if(k > 0){
                        Set<Integer> nSet = f.get(stones[i]+k);
                        if(nSet != null){
                            nSet.add(k);
                        }
                    }
                }
            }
        }

        return !f.get(stones[n-1]).isEmpty();
    }
}

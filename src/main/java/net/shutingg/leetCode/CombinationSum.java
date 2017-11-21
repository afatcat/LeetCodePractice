package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        track(candidates, target, new ArrayList<>(), result, 0);

        return result;
    }

    private void track(int[] candidates, int remain, List<Integer> current, List<List<Integer>> result, int start){
        for(int i=start; i<candidates.length; i++){
            if(remain - candidates[i] > 0){
                List<Integer> newList = new ArrayList<>(current);
                newList.add(candidates[i]);
                track(candidates, remain - candidates[i], newList, result, i);
            }else if(remain - candidates[i] == 0){
                current.add(candidates[i]);
                result.add(current);
                return;
            }else{
                return;
            }
        }
    }
}

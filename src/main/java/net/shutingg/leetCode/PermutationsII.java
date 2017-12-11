package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i < nums.length; i++){
            list.add(nums[i]);
        }
        for(Integer i:list){
            dfs(result, list, i, new ArrayList<>());
        }
        List<List<Integer>> asList = new ArrayList<>();
        for(List<Integer> l:result){
            asList.add(l);
        }
        return asList;
    }

    private void dfs(Set<List<Integer>> result, LinkedList<Integer> list, Integer i, List<Integer> current){
        if(list.size() == 1){
            current.add(i);
            result.add(current);
        }else{
            LinkedList<Integer> list2 = new LinkedList<>(list);
            list2.remove(i);
            current.add(i);
            for(Integer j:list2){
                dfs(result, list2, j, new ArrayList<>(current));
            }
        }
    }
}

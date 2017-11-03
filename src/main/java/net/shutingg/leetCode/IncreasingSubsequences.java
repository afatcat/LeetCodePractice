package net.shutingg.leetCode;

import java.util.*;

/**
 * Created by sguan on 11/3/17.
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for(int num:nums){
            Set<List<Integer>> result2 = new HashSet<>();
            for(List<Integer> list: result){
                if(list.get(list.size()-1) <= num){
                    List<Integer> list2 = new ArrayList<>(list);
                    list2.add(num);
                    result2.add(list2);
                }
            }
            result.addAll(result2);
            result.add(Arrays.asList(num));
        }
        List<List<Integer>> listResult = new ArrayList<>();
        for(List<Integer> list:result){
            if(list.size()>1){
                listResult.add(list);
            }
        }
        return listResult;
    }
}

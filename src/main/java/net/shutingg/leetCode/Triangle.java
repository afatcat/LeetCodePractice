package net.shutingg.leetCode;

import java.util.List;

/**
 * Created by sguan on 11/3/17.
 */
public class Triangle {
    /*
    Dynamic Programming
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] storage = new int[triangle.size()];
        for(int i=0; i<triangle.size(); i++){
            storage[i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0; j<=i; j++){
                storage[j] = Math.min(storage[j], storage[j+1]) + triangle.get(i).get(j);
            }
        }
        return storage[0];
    }


    /*
    Recursion method. It won't pass a stress test
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        return helper(0, 0, triangle);
    }

    private int helper(int col, int row, List<List<Integer>> triangle){
        int current = triangle.get(row).get(col);
        if(row == triangle.size()-1){
            return current;
        }else{
            int left = helper(col, row+1, triangle);
            int right = helper(col+1, row+1, triangle);
            return current + Math.min(left, right);
        }
    }
}

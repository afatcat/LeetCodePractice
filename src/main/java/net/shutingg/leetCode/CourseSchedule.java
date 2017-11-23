package net.shutingg.leetCode;

import java.util.List;
import java.util.LinkedList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }

        int m = prerequisites.length;
        if(m == 0){
            return true;
        }

        //construct
        List<Integer>[] listArray = new LinkedList[numCourses];
        for(int i = 0 ; i < m; i++){
            int loc = prerequisites[i][0];
            if(listArray[loc] == null){
                listArray[loc] = new LinkedList<>();
            }
            listArray[loc].add(prerequisites[i][1]);
        }

        //search for circle
        boolean[] visited = new boolean[numCourses];
        boolean success = true;
        for(int i = 0; i < listArray.length; i++){
            success = success && dfs(listArray, visited, i);
        }

        return success;
    }

    private boolean dfs(List<Integer>[] listArray, boolean[] visited, int target){
        if(visited[target]){
            return false;
        }
        visited[target] = true;
        if(listArray[target]!=null){
            for(int i:listArray[target]){
                if(!dfs(listArray, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }
}

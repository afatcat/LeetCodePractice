package net.shutingg.leetCode;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //construct graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            if(graph[prerequisites[i][0]] == null){
                graph[prerequisites[i][0]] = new ArrayList<>();
            }
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++){
            if(isLoop(graph, i, new HashSet<>())){
                return false;
            }
        }
        return true;
    }

    private boolean isLoop(List<Integer>[] graph, int u, Set<Integer> visited){
        if(visited.contains(u)){
            return true;
        }
        if(graph[u] == null){
            return false;
        }else{
            visited.add(u);
            List<Integer> neighbors = graph[u];
            for(int v:neighbors){
                if(isLoop(graph, v, visited)){
                    return true;
                }
                visited.remove(v);
            }
            return false;
        }
    }
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if(numCourses == 0){
//            return true;
//        }
//
//        int m = prerequisites.length;
//        if(m == 0){
//            return true;
//        }
//
//        //construct
//        List<Integer>[] listArray = new LinkedList[numCourses];
//        for(int i = 0 ; i < m; i++){
//            int loc = prerequisites[i][0];
//            if(listArray[loc] == null){
//                listArray[loc] = new LinkedList<>();
//            }
//            listArray[loc].add(prerequisites[i][1]);
//        }
//
//        //search for circle
//        boolean[] visited = new boolean[numCourses];
//        boolean success = true;
//        for(int i = 0; i < listArray.length; i++){
//            success = success && dfs(listArray, visited, i);
//        }
//
//        return success;
//    }
//
//    private boolean dfs(List<Integer>[] listArray, boolean[] visited, int target){
//        if(visited[target]){
//            return false;
//        }
//        visited[target] = true;
//        if(listArray[target]!=null){
//            for(int i:listArray[target]){
//                if(!dfs(listArray, visited, i)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}

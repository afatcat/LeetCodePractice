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

        Set<Integer> checked = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            if(!checked.contains(i)){
                if(isLoop(graph, i, new HashSet<>(), checked)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLoop(List<Integer>[] graph, int u, Set<Integer> visited, Set<Integer> checked){
        if(visited.contains(u)){
            return true;
        }
        if(graph[u] == null){
            return false;
        }else{
            visited.add(u);
            List<Integer> neighbors = graph[u];
            for(int v:neighbors){
                if(isLoop(graph, v, visited, checked)){
                    return true;
                }
                visited.remove(v);
                checked.add(v);
            }
            return false;
        }
    }
}

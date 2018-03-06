package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/course-schedule/
 */
public class CourseSchedule {
    /**
     * BFS
     *
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<Integer>[] lists = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int m = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            lists[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int a = queue.poll();
            for (Integer b : lists[a]) {
                degree[b]--;
                if (degree[b] == 0) {
                    queue.offer(b);
                }
            }
        }

        return count == numCourses;
    }

    /**
     * DFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
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

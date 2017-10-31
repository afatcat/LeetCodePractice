package net.shutingg.leetCode;

import java.util.*;

/**
 * Created by sguan on 10/30/17.
 */
public class EvaluateDivision {
    //4 ms, beats 23.77%
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Set<String> variablesSet = new HashSet<>();
        for(int i=0;i<equations.length;i++){
            for(int j=0;j<equations[0].length;j++){
                variablesSet.add(equations[i][j]);
            }
        }
        String[] variables = new String[variablesSet.size()];
        int index = 0;
        for(String var:variablesSet){
            variables[index]=var;
            index++;
        }
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i =0; i<variables.length; i++){
            indexMap.put(variables[i], i);
        }

        Map<Integer, Map<Integer, Double>> equationMap = new HashMap<>();
        for(int i=0; i<equations.length; i++){
            if(equationMap.containsKey(indexMap.get(equations[i][0]))){
                Map<Integer, Double> neighbours = equationMap.get(indexMap.get(equations[i][0]));
                neighbours.put(indexMap.get(equations[i][1]), values[i]);
            }else{
                Map<Integer, Double> neighbours = new HashMap<>();
                neighbours.put(indexMap.get(equations[i][1]), values[i]);
                equationMap.put(indexMap.get(equations[i][0]), neighbours);
            }
            if(equationMap.containsKey(indexMap.get(equations[i][1]))){
                Map<Integer, Double> neighbours = equationMap.get(indexMap.get(equations[i][1]));
                neighbours.put(indexMap.get(equations[i][0]), 1/values[i]);
            }else{
                Map<Integer, Double> neighbours = new HashMap<>();
                neighbours.put(indexMap.get(equations[i][0]), 1/values[i]);
                equationMap.put(indexMap.get(equations[i][1]), neighbours);
            }
        }

        double[] results = new double[queries.length];
        for(int i=0; i<queries.length; i++){
            if(!equationMap.containsKey(indexMap.get(queries[i][0])) || !equationMap.containsKey(indexMap.get(queries[i][1]))){
                results[i]=-1;
            }else if(queries[i][0].equals(queries[i][1])){
                results[i]=1;
            }else{
                int start = indexMap.get(queries[i][0]);
                int end = indexMap.get(queries[i][1]);
                if(equationMap.get(start).containsKey(end)){
                    results[i] = equationMap.get(start).get(end);
                }else{
                    results[i] = bfs(start, end, equationMap, variables.length);
                }
            }
        }

        return results;
    }

    private double bfs(int start, int end, Map<Integer, Map<Integer, Double>> equationMap, int size){
        boolean[] visited = new boolean[size];
        double[] distances = new double[size];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int q = queue.pop();
            Map<Integer, Double> neighbours = equationMap.get(q);
            if(neighbours.containsKey(end)){
                return distances[q]==0?neighbours.get(end):neighbours.get(end)*distances[q];
            }else{
                for(int v:neighbours.keySet()){
                    if(!visited[v]){
                        visited[v] = true;
                        distances[v] = distances[q]==0?neighbours.get(v):neighbours.get(v)*distances[q];
                        queue.add(v);
                    }
                }
            }
        }
        return -1;
    }
}

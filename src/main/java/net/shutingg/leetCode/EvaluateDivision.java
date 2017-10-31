package net.shutingg.leetCode;

import java.util.*;

/**
 * Created by sguan on 10/30/17.
 */
public class EvaluateDivision {
    //3 ms, beats 60.69%
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> equationMap = new HashMap<>();
        for(int i=0; i<equations.length; i++){
            if(equationMap.containsKey(equations[i][0])){
                Map<String, Double> neighbours = equationMap.get(equations[i][0]);
                neighbours.put(equations[i][1], values[i]);
            }else{
                Map<String, Double> neighbours = new HashMap<>();
                neighbours.put(equations[i][1], values[i]);
                equationMap.put(equations[i][0], neighbours);
            }
            if(equationMap.containsKey(equations[i][1])){
                Map<String, Double> neighbours = equationMap.get(equations[i][1]);
                neighbours.put(equations[i][0], 1/values[i]);
            }else{
                Map<String, Double> neighbours = new HashMap<>();
                neighbours.put(equations[i][0], 1/values[i]);
                equationMap.put(equations[i][1], neighbours);
            }
        }

        double[] results = new double[queries.length];
        for(int i=0; i<queries.length; i++){
            if(!equationMap.containsKey(queries[i][0]) || !equationMap.containsKey(queries[i][1])){
                results[i]=-1;
            }else if(queries[i][0].equals(queries[i][1])){
                results[i]=1;
            }else{
                String start = queries[i][0];
                String end = queries[i][1];
                if(equationMap.get(start).containsKey(end)){
                    results[i] = equationMap.get(start).get(end);
                }else{
                    results[i] = bfs(start, end, equationMap);
                }
            }
        }

        return results;
    }

    private double bfs(String start, String end, Map<String, Map<String, Double>> equationMap){
        Set<String> visited = new HashSet<>();
        Map<String, Double> distanceMap = new HashMap<>();

        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            String q = queue.pop();
            Map<String, Double> neighbours = equationMap.get(q);
            if(neighbours.containsKey(end)){
                return !distanceMap.containsKey(q)?neighbours.get(end):neighbours.get(end)*distanceMap.get(q);
            }else{
                for(String v:neighbours.keySet()){
                    if(!visited.contains(v)){
                        visited.add(v);
                        distanceMap.put(v, !distanceMap.containsKey(q)?neighbours.get(v):neighbours.get(v)*distanceMap.get(q));
                        queue.add(v);
                    }
                }
            }
        }
        return -1;
    }
}

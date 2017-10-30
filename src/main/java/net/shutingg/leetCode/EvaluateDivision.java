package net.shutingg.leetCode;

import java.util.*;

/**
 * Created by sguan on 10/30/17.
 */
public class EvaluateDivision {
    class MyPair{
        String divisor;
        double value;

        public MyPair(String divisor, double value) {
            this.divisor = divisor;
            this.value = value;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Set<String> variablesSet = new HashSet<>();
        for(int i=0;i<equations.length;i++){
            for(int j=0;j<equations[0].length;j++){
                variablesSet.add(equations[i][j]);
            }
        }
        String[] variables = new String[variablesSet.size()];
        for(String var:variables){

        }


        Map<String, List<MyPair>> equationMap = new HashMap<>();
        for(int i=0; i<equations.length; i++){
            if(equationMap.containsKey(equations[i][0])){
                equationMap.get(equations[i][0]).add(new MyPair(equations[i][1], values[i]));
            }else{
                List<MyPair> list = new ArrayList<>();
                list.add(new MyPair(equations[i][1], values[i]));
            }
            if(equationMap.containsKey(equations[i][1])){
                equationMap.get(equations[i][1]).add(new MyPair(equations[i][0], 1/values[i]));
            }else{
                List<MyPair> list = new ArrayList<>();
                list.add(new MyPair(equations[i][0], 1/values[i]));
            }
        }

        double[] results = new double[queries.length];
        for(int i=0; i<queries.length; i++){
            if(!equationMap.containsKey(queries[i][0]) || !equationMap.containsKey(queries[i][1])){
                results[i]=-1;
            }else{
                Map<String, Boolean> visited = new HashMap<>();;
                for(String key: equationMap.keySet()){
                    visited.put(key, false);
                }
                Map<String, Double> distances = new HashMap<>();
                Map<String, String> prev = new HashMap<>();
                List<String> queue = new LinkedList<>();
                queue.add(queries[i][0]);
                while(!queue.isEmpty()){
                    for(String q:queue){
                        List<MyPair> neighbours = equationMap.get(q);
                        if(neighbours!=null){
                            for(MyPair pair:neighbours){
                                if(!visited.get(pair.divisor)){
                                    visited.put(pair.divisor, true);

                                }
                            }
                        }
                    }
                }


            }
        }
    }
}

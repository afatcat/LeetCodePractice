package net.shutingg.leetCode;

import java.util.*;

class DirectedGraphNode {
     int label;
     ArrayList<DirectedGraphNode> neighbors;
     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 }

/**
 * http://lintcode.com/en/problem/topological-sorting/
 */
public class TopologicalSorting {
    /**
     * Graph - BFS, in degree
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        if(graph == null || graph.size() == 0) {
            return graph;
        }

        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> inDegree = new HashMap<>();
        for(DirectedGraphNode node:graph){
            if(inDegree.get(node) == null){
                inDegree.put(node, 0);
            }
            for(DirectedGraphNode nei:node.neighbors){
                if(inDegree.get(nei) == null) {
                    inDegree.put(nei, 1);
                }else{
                    int c = inDegree.get(nei);
                    inDegree.put(nei, c+1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode key: inDegree.keySet()){
            if(inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        while(!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            res.add(cur);
            inDegree.remove(cur);
            for(DirectedGraphNode nei:cur.neighbors){
                if(inDegree.get(nei) != null){
                    if(inDegree.get(nei) > 1){
                        inDegree.put(nei, inDegree.get(nei) -1);
                    }else{
                        inDegree.put(nei, 0);
                        queue.offer(nei);
                    }
                }
            }
        }

        return res;
    }
}

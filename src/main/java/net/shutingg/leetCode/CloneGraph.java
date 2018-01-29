package net.shutingg.leetCode;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
 }

/**
 * http://lintcode.com/en/problem/clone-graph/
 */
public class CloneGraph {
    /**
     * BFS
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }

        //clone nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> reflection = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.removeFirst();
            if(reflection.get(current)==null){
                UndirectedGraphNode copy = new UndirectedGraphNode(current.label);
                reflection.put(current, copy);
                queue.addAll(current.neighbors);
            }
        }

        //clone edges
        for(UndirectedGraphNode current:reflection.keySet()){
            UndirectedGraphNode copy = reflection.get(current);
            current.neighbors.stream().forEach((element) -> copy.neighbors.add(reflection.get(element)));
        }

        return reflection.get(node);
    }
}

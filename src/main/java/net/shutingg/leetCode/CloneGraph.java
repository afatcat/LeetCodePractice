package net.shutingg.leetCode;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
 }

public class CloneGraph {
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
        queue.add(node);
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.removeFirst();
            if(!visited.contains(current)){
                UndirectedGraphNode copy = reflection.get(current);
                current.neighbors.stream().forEach((element) -> {copy.neighbors.add(reflection.get(element));});
                visited.add(current);
                queue.addAll(current.neighbors);
            }
        }

        return reflection.get(node);
    }
}

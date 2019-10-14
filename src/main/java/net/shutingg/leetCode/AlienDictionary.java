package net.shutingg.leetCode;

import java.util.*;

public class AlienDictionary {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        if (words == null) {
            return "";
        }
        Map<Character, Node> map = new HashMap<>();
        Map<Character, Set<Character>> indegrees = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)('a' + i), new Node((char)('a' + i)));
        }
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            int length = Math.min(words[i].length(), words[j].length());
            for (int k = 0; k < length; k++) {
                char ci = words[i].charAt(k);
                char cj = words[j].charAt(k);
                if (ci == cj) {
                    charSet.add(ci);
                    continue;
                }
                charSet.add(ci);
                charSet.add(cj);
                if (!indegrees.containsKey(cj)) {
                    indegrees.put(cj, new HashSet<>());
                }
                indegrees.get(cj).add(ci);
                map.get(ci).neighbors.add(map.get(cj));
            }
            if (words[i].length() > length) {
                for (int k = length; k < words[i].length(); k++) {
                    char ci = words[i].charAt(k);
                    charSet.add(ci);
                }
            }
            if (words[j].length() > length) {
                for (int k = length; k < words[j].length(); k++) {
                    char cj = words[j].charAt(k);
                    charSet.add(cj);
                }
            }
        }
        Map<Character, Integer> ind = new HashMap<>();
        for (Character ch: indegrees.keySet()) {
            ind.put(ch, indegrees.get(ch).size());
        }
        LinkedList<Node> queue = new LinkedList<>();
        for (char ch: charSet) {
            if (!ind.containsKey(ch)) {
                queue.offer(map.get(ch));
            }
        }
        if (queue.isEmpty()) {
            return "";
        }
        Collections.sort(queue, (a, b) -> a.c - b.c);
        String result = "";
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            charSet.remove(node.c);
            result += node.c;
            Collections.sort(node.neighbors, (a, b) -> a.c - b.c);
            for (Node child: node.neighbors) {
                ind.put(child.c, ind.get(child.c) - 1);
                if (ind.get(child.c) == 0) {
                    queue.offer(child);
                }
            }
        }
        return result;
    }

    class Node {
        char c;
        List<Node> neighbors;

        Node(char c) {
            this.c = c;
            neighbors = new ArrayList<>();
        }
    }
}

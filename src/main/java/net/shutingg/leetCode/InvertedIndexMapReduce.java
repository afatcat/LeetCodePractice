package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class OutputCollector<K, V> {
    public void collect(K key, V value) {

    }// Adds a key/value pair to the output buffer
}

class Document {
    public int id;
    public String content;
}

public class InvertedIndexMapReduce {
    public static class Map {
        public void map(String key, Document value,
                        OutputCollector<String, Integer> output) {
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.split(" ");
            for (String word : words) {
                if ("".equals(word)) {
                    continue;
                }
                output.collect(word, value.id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            int prev = -1;
            List<Integer> list = new ArrayList<>();
            while (values.hasNext()) {
                int v = values.next();
                if (prev != v) {
                    list.add(v);
                }
                prev = v;
            }
            output.collect(key, list);
        }
    }
}

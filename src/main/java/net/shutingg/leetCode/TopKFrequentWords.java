package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/top-k-frequent-words/
 */
public class TopKFrequentWords {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            counts.put(words[i], counts.getOrDefault(words[i], 0) + 1);
        }
        Pair[] pairs = new Pair[counts.size()];
        int i = 0;
        for (String word : counts.keySet()) {
            pairs[i] = new Pair(word, counts.get(word));
            i++;
        }
        Arrays.sort(pairs, (a, b) -> {
            if (a.frequency == b.frequency) {
                return a.word.compareTo(b.word);
            } else {
                return b.frequency - a.frequency;
            }
        });
        int length = pairs.length >= k ? k : pairs.length;
        String[] results = new String[length];
        for (int j = 0; j < length; j++) {
            results[j] = pairs[j].word;
        }

        return results;
    }

    class Pair {
        String word;
        int frequency;

        Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
}

package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/word-squares/
 */
public class WordSquares {
    /**
     * Trie
     *
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0 || words[0].length() == 0) {
            return res;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            List<String> ans = new ArrayList<>();
            ans.add(word);
            dfs(ans, words[0].length(), trie, res);
        }

        return res;
    }

    private void dfs(List<String> ans, int n, Trie trie, List<List<String>> res) {
        if (ans.size() == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        String prefix = "";
        for (int i = 0; i < ans.size(); i++) {
            prefix += ans.get(i).charAt(ans.size());
        }

        List<String> candidates = trie.getPrefix(prefix);
        if (candidates == null) {
            return;
        }
        for (String word : candidates) {
            ans.add(word);
            dfs(ans, n, trie, res);
            ans.remove(ans.size() -1);
        }
    }

    class Trie {
        Trie[] children;
        List<String> startWith;

        Trie() {
            children = new Trie[26];
            startWith = new ArrayList<>();
        }

        void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
                trie.startWith.add(word);
            }
        }

        List<String> getPrefix(String prefix) {
            Trie trie = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (trie.children[index] == null) {
                    return null;
                }
                trie = trie.children[index];
            }
            return trie.startWith;
        }
    }
}

package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/word-search-ii/
 */
public class WordSearchII {
    /**
     * Trie - array
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) {
            return res;
        }
        //words to trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        //search
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                dfs(set, trie, new HashSet<>(), board, i, j);
            }
        }

        res = new ArrayList(set);
        return res;
    }



    private void dfs(Set<String> res, Trie root, Set<Pair> visited, char[][] board, int i, int j) {
        Pair pair = new Pair(i, j, board.length);
        if (visited.contains(pair)) {
            return;
        }
        Trie cur = root.search(board[i][j]);
        if (cur != null) {
            visited.add(pair);
            if (cur.hasWord) {
                res.add(cur.word);
            }
            if (i < board.length - 1) {
                dfs(res, cur, visited, board, i+1, j);
            }
            if (j < board[0].length - 1) {
                dfs(res, cur, visited, board, i, j+1);
            }
            if (i > 0) {
                dfs(res, cur, visited, board, i-1, j);
            }
            if (j > 0) {
                dfs(res, cur, visited, board, i, j-1);
            }
            visited.remove(pair);
        }
    }

    class Trie {
        Trie[] children;
        boolean hasWord;
        String word;

        Trie() {
            children = new Trie[26];
        }

        void insert(String word) {
            char[] wc = word.toCharArray();
            Trie trie = this;
            for (int i = 0; i < wc.length; i++) {
                int index = wc[i] - 'a';
                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
            }
            trie.hasWord = true;
            trie.word = word;
        }

        Trie search(char c) {
            return this.children[c - 'a'];
        }
    }

    class Pair {
        int x;
        int y;
        int length;

        Pair(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair another = (Pair) obj;
            if (this.x == another.x && this.y == another.y) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x * length + y;
        }
    }
}

package net.shutingg.leetCode;

/**
 * https://leetcode.com/contest/weekly-contest-81/problems/short-encoding-of-words/
 *
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

 For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

 Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

 What is the length of the shortest reference string S possible that encodes the given words?

 Example:

 Input: words = ["time", "me", "bell"]
 Output: 10
 Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 Note:

 1 <= words.length <= 2000.
 1 <= words[i].length <= 7.
 Each word has only lowercase letters.
 */
public class ShortEncodingOfWords {
    private int count = 0;
    public int minimumLengthEncoding(String[] words) {
        if (words == null) {
            return 0;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        countLength(trie);

        return count;
    }

    private void countLength(Trie trie) {
        if (!trie.hasChildren) {
            if (trie.word != null) {
                count = count + trie.word.length() + 1;
            }
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (trie.children[i] != null) {
                countLength(trie.children[i]);
            }
        }
    }

    class Trie {
        Trie[] children;
        String word;
        boolean hasChildren;

        Trie() {
            children = new Trie[26];
        }

        void insert(String word) {
            char[] cs = word.toCharArray();
            Trie trie = this;
            for (int i = cs.length - 1; i >= 0; i--) {
                if (trie.children[cs[i] - 'a'] == null) {
                    trie.children[cs[i] - 'a'] = new Trie();
                    trie.hasChildren = true;
                }
                trie = trie.children[cs[i] - 'a'];
            }
            trie.word = word;
        }
    }
}

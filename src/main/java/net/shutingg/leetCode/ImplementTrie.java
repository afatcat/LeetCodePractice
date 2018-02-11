package net.shutingg.leetCode;

public class ImplementTrie {
    ImplementTrie[] children;
    boolean hasWord;
    String word;

    public ImplementTrie() {
        children = new ImplementTrie[26];
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        ImplementTrie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new ImplementTrie();
            }
            trie = trie.children[index];
        }
        if (!trie.hasWord) {
            trie.hasWord = true;
            trie.word = word;
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        ImplementTrie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (trie.children[index] == null) {
                return false;
            }
            trie = trie.children[index];
        }
        return trie.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        ImplementTrie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (trie.children[index] == null) {
                return false;
            }
            trie = trie.children[index];
        }
        return true;
    }
}

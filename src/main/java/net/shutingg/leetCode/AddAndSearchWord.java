package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/add-and-search-word/
 */
public class AddAndSearchWord {
    private AddAndSearchWord[] children;
    private boolean hasWord;

    public AddAndSearchWord() {
        children = new AddAndSearchWord[26];
    }
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        char[] wc = word.toCharArray();
        AddAndSearchWord wd = this;
        for (int i = 0; i < word.length(); i++) {
            int index = wc[i]-'a';
            if (wd.children[index] == null) {
                wd.children[index] = new AddAndSearchWord();
            }
            wd = wd.children[index];
        }
        wd.hasWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, this);
    }

    private boolean search(char[] wc, int loc, AddAndSearchWord wd) {
        if (loc == wc.length - 1) {
            if (wc[loc] != '.') {
                return (wd.children[wc[loc] - 'a'] != null && wd.children[wc[loc] - 'a'].hasWord);
            } else {
                boolean found = false;
                for (int i = 0 ; i < 26; i++) {
                    found |= (wd.children[i] != null && wd.children[i].hasWord);
                }
                return found;
            }
        }
        if (wc[loc] != '.') {
            if (wd.children[wc[loc] - 'a'] == null) {
                return false;
            }
            return search(wc, loc+1, wd.children[wc[loc] - 'a']);
        } else {
            boolean found = false;
            for (int i = 0 ; i < 26; i++) {
                if (wd.children[i] != null) {
                    found |= search(wc, loc+1, wd.children[i]);
                }
            }
            return found;
        }
    }
}

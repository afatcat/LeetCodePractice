package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * DP + DFS + Trie
 * http://www.lintcode.com/en/problem/k-edit-distance/#
 */
public class KEditDistance {
    class Trie{
        Trie[] children;
        boolean hasWord;
        String word;

        public Trie(){
            children = new Trie[26];
        }

        void insert(String word){
            Trie trie = this;
            int l = word.length();
            for(int i = 0; i < l; i++){
                int p = word.charAt(i) - 'a';
                if(trie.children[p] == null){
                    trie.children[p] = new Trie();
                }
                trie = trie.children[p];
            }
            trie.hasWord = true;
            trie.word = word;
        }
    }

    /*
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     */
    public List<String> kDistance(String[] words, String target, int k) {
        // f[Sq][j] = f[Sp][j] + 1 //delete
        // OR
        // f[Sq][j] = f[Sq][j-1] +1 //insert
        // OR
        // f[Sq][j] = f[Sp][j-1] +1 //replace
        //OR
        // f[Sq][j] = f[Sp][j-1] //A[j] == Q

        int n = words.length;

        //insert words to Trie
        Trie root = new Trie();
        for(int i = 0; i < n; i++){
            root.insert(words[i]);
        }

        //""
        int m = target.length();
        int[] f = new int[m+1];
        for(int i = 0; i <= m; i++){
            f[i] = i;
        }

        List<String> res = new ArrayList<>();
        dfs(root, f, target, k, res);

        return res;
    }

    private void dfs(Trie trie, int[] f, String target, int k, List<String> res){
        int m = target.length();
        if(trie.hasWord && f[m] <= k){
            res.add(trie.word);
        }

        for(int j = 0; j < 26; j++){
            if(trie.children[j] == null){
                continue;
            }

            int[] nf = new int[m+1];
            nf[0] = f[0] + 1;

            for(int i = 0; i < m; i++){
                nf[i+1] = Math.min(f[i+1] + 1, nf[i] + 1);
                if(j == target.charAt(i) - 'a'){
                    nf[i+1] = Math.min(nf[i+1], f[i]);
                }else{
                    nf[i+1] = Math.min(nf[i+1], f[i] + 1);
                }
            }

            dfs(trie.children[j], nf, target, k, res);
        }
    }
}

package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

public class StringsHomomorphism {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        int n = s.length();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverse = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.get(cs[i]) != null){
                if(map.get(cs[i]) != ct[i]){
                    return false;
                }
                if(reverse.get(ct[i]) != cs[i]){
                    return false;
                }
            }else{
                map.put(cs[i], ct[i]);
                if(reverse.get(ct[i]) != null){
                    return false;
                }
                reverse.put(ct[i], cs[i]);
            }
        }

        return true;
    }
}

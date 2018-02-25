package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String S, String T) {
        if (S == null || T == null) {
            return "";
        }

        char[] sc = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sc.length; i++) {
            map.put(sc[i], i);
        }
        char[] tc = T.toCharArray();
        Character[] ttc = new Character[tc.length];
        for (int i = 0; i < ttc.length; i++) {
            ttc[i] = tc[i];
        }

        Comparator<Character> com = new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                Integer ap = map.get(a);
                if (ap == null) {
                    ap = 27;
                }
                Integer bp = map.get(b);
                if (bp == null) {
                    bp = 27;
                }
                return ap -bp;
            }
        };

        Arrays.sort(ttc, com);
        for (int i = 0; i < ttc.length; i++) {
            tc[i] = ttc[i];
        }
        return new String(tc);
    }
}

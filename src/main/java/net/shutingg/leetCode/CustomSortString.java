package net.shutingg.leetCode;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CustomSortString {
    /**
     * Stream converting char[] to Character[]
     */
    public String customSortString(String S, String T) {
        if (S == null || T == null) {
            return "";
        }

        char[] sc = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sc.length; i++) {
            map.put(sc[i], i);
        }
        Character[] tChar = T.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(tChar, (a, b) -> {
            Integer ap = map.get(a);
            if (ap == null) {
                ap = 27;
            }
            Integer bp = map.get(b);
            if (bp == null) {
                bp = 27;
            }
            return ap -bp;
        });
        char[] tc = new char[tChar.length];
        for (int i = 0; i < tChar.length; i++) {
            tc[i] = tChar[i];
        }
        return new String(tc);
    }

    /**
     * IntStream.range(st,end) replaces forloop
     * Note that stream makes things slow
     *
     * @param S
     * @param T
     * @return
     */
    public String customSortString2(String S, String T) {
        if (S == null || T == null) {
            return "";
        }

        char[] sc = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        IntStream.range(0, S.length()).forEach(i -> map.put(sc[i], i));

        Comparator<Character> com = Comparator.comparingInt(c -> map.getOrDefault(c, 27));

        Character[] tChar = T.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(tChar, com);
        char[] tc = new char[tChar.length];
        IntStream.range(0, tChar.length).forEach(i -> tc[i] = tChar[i]);
        return new String(tc);
    }
}

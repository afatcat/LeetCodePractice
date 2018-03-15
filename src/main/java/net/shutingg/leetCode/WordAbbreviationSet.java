package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAbbreviationSet {
    private Map<String, List<String>> abbMap;
    /*
    * @param dictionary: a list of words
    */public WordAbbreviationSet(String[] dictionary) {
        abbMap = new HashMap<>();
        for (String word : dictionary) {
            String abb = getAbb(word);
            abbMap.putIfAbsent(abb, new ArrayList<>());
            if (!abbMap.get(abb).contains(word)) {
                abbMap.get(abb).add(word);
            }
        }
    }

    private String getAbb(String word) {
        if (word.length() <= 2) {
            return word;
        }

        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        String abb = getAbb(word);
        if (abbMap.containsKey(abb)) {
            if (abbMap.get(abb).size() > 1) {
                return false;
            }
            return word.equals(abbMap.get(abb).get(0));
        }
        return true;
    }
}

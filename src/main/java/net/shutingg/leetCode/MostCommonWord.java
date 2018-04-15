package net.shutingg.leetCode;

import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 Example:
 Input:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 Output: "ball"
 Explanation:
 "hit" occurs 3 times, but it is a banned word.
 "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 Note that words in the paragraph are not case sensitive,
 that punctuation is ignored (even if adjacent to words, such as "ball,"),
 and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null || paragraph.length() == 0) {
            return "";
        }

        String[] words = paragraph.split("\\W+");
        Map<String, Integer> counts = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        for (String ban : banned) {
            banSet.add(ban);
        }
        String maxWord = "";
        int max = 0;
        for (String word : words) {
            String lowWord = word.toLowerCase();
            if (!"".equals(lowWord) && !banSet.contains(lowWord.toLowerCase())) {
                counts.put(lowWord, counts.getOrDefault(lowWord, 0) + 1);
                if (counts.get(lowWord) > max) {
                    max = counts.get(lowWord);
                    maxWord = lowWord;
                }
            }
        }

        return maxWord;
    }
}

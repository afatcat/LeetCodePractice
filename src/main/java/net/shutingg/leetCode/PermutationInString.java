package net.shutingg.leetCode;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] counts = new int[26];
        char[] cs = s1.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            counts[cs[i] - 'a']++;
        }
        char[] cs2 = s2.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            counts[cs2[i] - 'a']--;
        }
        if (isMatch(counts)) {
            return true;
        }
        int i = 0;
        int j = cs.length;
        while (j < cs2.length) {
            counts[cs2[i] - 'a']++;
            counts[cs2[j] - 'a']--;
            i++;
            j++;
            if (isMatch(counts)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

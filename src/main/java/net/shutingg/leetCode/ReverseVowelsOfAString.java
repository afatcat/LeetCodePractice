package net.shutingg.leetCode;

public class ReverseVowelsOfAString {
    private static char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;

        while (i < j) {
            while (!isVowel(cs[i]) && i < j) {
                i++;
            }
            while (!isVowel(cs[j]) && i < j) {
                j--;
            }
            if (i < j) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                i++;
                j--;
            }
        }

        return new String(cs);
    }

    private boolean isVowel(char c) {
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) {
                return true;
            }
        }
        return false;
    }
}

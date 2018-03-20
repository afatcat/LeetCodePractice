package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/add-binary/description/
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = ac.length -1;
        int j = bc.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int aInt = i < 0 ? 0 : ac[i] - '0';
            int bInt = j < 0 ? 0 : bc[j] - '0';
            int sum = aInt + bInt + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}

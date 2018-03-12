package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class StringsSerialization {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.replaceAll(":", "::"));
            sb.append(":;");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ':') {
                if (cs[i + 1] == ';') {
                    list.add(sb.toString());
                    sb = new StringBuilder();

                } else {
                    sb.append(cs[i + 1]);
                }
                i++;
            } else {
                sb.append(cs[i]);
            }
        }
        list.add(sb.toString());
        return list;
    }
}

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
            str.replaceAll(":", "::");
            sb.append(str);
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
        String[] strs = str.split(":;");
        List<String> list = new ArrayList<>();
        for (String s : strs) {
            s.replaceAll("::", ":");
            list.add(s);
        }
        return list;
    }
}

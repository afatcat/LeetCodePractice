package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by sguan on 11/8/17.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList()).stream().sorted((String s1, String s2) -> -(s1+s2).compareTo(s2+s1)).reduce("", (String s1, String s2)->!s1.equals("0")?s1+s2:s2);
    }
}

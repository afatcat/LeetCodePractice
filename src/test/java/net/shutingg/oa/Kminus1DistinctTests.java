package net.shutingg.oa;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Kminus1DistinctTests {
    private Kminus1Distinct kminus1Distinct;

    @Before
    public void setup() {
        kminus1Distinct = new Kminus1Distinct();
    }

    @Test
    public void testSubStringsLessKDist() {
        String input = "awaglk";
        int k = 4;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList("awag");
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist2() {
        String input = "democracy";
        int k = 5;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList("ocrac", "cracy");
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist3() {
        String input = "acca";
        int k = 3;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList("acc", "cca");
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist4() {
        String input = "aaaaa";
        int k = 3;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList();
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist5() {
        String input = "abcde";
        int k = 3;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList();
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist6() {
        String input = "aabbccddee";
        int k = 3;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList("aab", "abb", "bbc","bcc", "ccd", "cdd", "dde", "dee");
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist7() {
        String input = "a";
        int k = 1;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList();
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testSubStringsLessKDist8() {
        String input = "abcaabca";
        int k = 4;
        List<String> result = kminus1Distinct.subStringsLessKDist(input, k);
        List<String> expected = Arrays.asList("abca", "bcaa", "caab", "aabc");
        Collections.sort(expected);
        Collections.sort(result);
        assertThat(result, is(expected));
    }
}

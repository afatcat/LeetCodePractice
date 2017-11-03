package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by sguan on 11/3/17.
 */
public class IncreasingSubsequencesTests {
    private IncreasingSubsequences increasingSubsequences;
    @Before
    public void setup(){
        increasingSubsequences = new IncreasingSubsequences();
    }

    @Test
    public void testFindSubsequences(){
        int[] input = {4, 6, 7, 7};
        List<List<Integer>> result = increasingSubsequences.findSubsequences(input);
        System.out.println(result);
        assertEquals(8, result.size());
        assertThat(result, hasItem(Arrays.asList(4, 6)));
        assertThat(result, hasItem(Arrays.asList(4, 7)));
        assertThat(result, hasItem(Arrays.asList(4, 6, 7)));
        assertThat(result, hasItem(Arrays.asList(4, 6, 7, 7)));
        assertThat(result, hasItem(Arrays.asList(6, 7)));
        assertThat(result, hasItem(Arrays.asList(6, 7, 7)));
        assertThat(result, hasItem(Arrays.asList(7, 7)));
        assertThat(result, hasItem(Arrays.asList(4, 7, 7)));
    }
}

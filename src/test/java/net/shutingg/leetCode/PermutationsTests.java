package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sguan on 11/2/17.
 */
public class PermutationsTests {
    private Permutations permutations;
    @Before
    public void setup(){
        permutations = new Permutations();
    }

    @Test
    public void testPermute(){
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new Integer[]{1,2,3}));
        expected.add(Arrays.asList(new Integer[]{1,3,2}));
        expected.add(Arrays.asList(new Integer[]{2,1,3}));
        expected.add(Arrays.asList(new Integer[]{2,3,1}));
        expected.add(Arrays.asList(new Integer[]{3,1,2}));
        expected.add(Arrays.asList(new Integer[]{3,2,1}));
        assertEquals(6, result.size());
        System.out.println(result);
        assertEquals(expected, result);
    }
}

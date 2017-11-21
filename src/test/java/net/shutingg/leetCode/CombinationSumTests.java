package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsCollectionContaining.*;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumTests {
    private CombinationSum combinationSum;
    @Before
    public void setup(){
        combinationSum = new CombinationSum();
    }
    @Test
    public void testCombinationSum(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(2);
        list2.add(3);

        List<List<Integer>> actual = combinationSum.combinationSum(new int[]{7, 3, 6, 2}, 7);
        assertThat(actual, hasItem(list1));
        assertThat(actual, hasItem(list2));
    }
}

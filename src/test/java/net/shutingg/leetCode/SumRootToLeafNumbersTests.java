package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sguan on 11/1/17.
 */
public class SumRootToLeafNumbersTests {
    private SumRootToLeafNumbers sumRootToLeafNumbers;
    @Before
    public void setup(){
        sumRootToLeafNumbers = new SumRootToLeafNumbers();
    }

    @Test
    public void testSumNumbers(){
        TreeNode root = new TreeNode(1);
        assertEquals(1, sumRootToLeafNumbers.sumNumbers(root));

        TreeNode left = new TreeNode(2);
        root.left = left;
        root.right = new TreeNode(3);
        assertEquals(25, sumRootToLeafNumbers.sumNumbers(root));

        left.left = new TreeNode(4);
        assertEquals(137, sumRootToLeafNumbers.sumNumbers(root));

        left.right = new TreeNode(5);
        assertEquals(262, sumRootToLeafNumbers.sumNumbers(root));
    }
}

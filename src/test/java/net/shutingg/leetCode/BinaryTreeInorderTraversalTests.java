package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeInorderTraversalTests {
    private BinaryTreeInorderTraversal binaryTreeInorderTraversal;
    @Before
    public void setup(){
        binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
    }

    @Test
    public void testInorderTraversal(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        assertArrayEquals(new Integer[]{1,3,2}, binaryTreeInorderTraversal.inorderTraversal(root).toArray());
    }

    @Test
    public void testInorderTraversal2(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left = new TreeNode(4);
        assertArrayEquals(new Integer[]{4, 1, 3, 2}, binaryTreeInorderTraversal.inorderTraversal(root).toArray());
    }
}

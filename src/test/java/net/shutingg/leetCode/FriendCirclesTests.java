package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FriendCirclesTests {
    private FriendCircles friendCircles;
    @Before
    public void setup(){
        friendCircles = new FriendCircles();
    }

    @Test
    public void testFindCircleNum2(){
        int[][] m1 = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        assertEquals(2, friendCircles.findCircleNum2(m1));

        assertEquals(1, friendCircles.findCircleNum2(new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}
        }));

        assertEquals(1, friendCircles.findCircleNum2(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        }));
    }

    @Test
    public void testFindCircleNum(){
        int[][] m1 = {{1,1,0},
                      {1,1,0},
                      {0,0,1}};
        assertEquals(2, friendCircles.findCircleNum(m1));

        assertEquals(1, friendCircles.findCircleNum(new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}
        }));

        assertEquals(1, friendCircles.findCircleNum(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        }));
    }
}

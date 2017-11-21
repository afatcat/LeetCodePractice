package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseScheduleTests {
    private CourseSchedule courseSchedule;

    @Before
    public void setup(){
        courseSchedule = new CourseSchedule();
    }
    @Test
    public void testCanFinish(){
        int[][] input = new int[3][2];
        input[0] = new int[]{1,0};
        input[1] = new int[]{2,0};
        input[2] = new int[]{1,2};
        assertFalse(courseSchedule.canFinish(3, input));

        input = new int[1][2];
        input[0] = new int[]{1,0};
        assertTrue(courseSchedule.canFinish(2, input));
    }
}

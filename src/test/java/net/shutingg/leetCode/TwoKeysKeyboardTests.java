package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sguan on 10/20/17.
 */
public class TwoKeysKeyboardTests {
    private TwoKeysKeyboard twoKeysKeyboard;
    @Before
    public void setup(){
        twoKeysKeyboard = new TwoKeysKeyboard();
    }
    @Test
    public void testMinSteps(){
        assertEquals(2, twoKeysKeyboard.minSteps(2));
        assertEquals(3, twoKeysKeyboard.minSteps(3));
        assertEquals(4, twoKeysKeyboard.minSteps(4));
        assertEquals(5, twoKeysKeyboard.minSteps(5));
        assertEquals(5, twoKeysKeyboard.minSteps(6));
        assertEquals(7, twoKeysKeyboard.minSteps(7));
        assertEquals(6, twoKeysKeyboard.minSteps(8));
        assertEquals(6, twoKeysKeyboard.minSteps(9));
        assertEquals(7, twoKeysKeyboard.minSteps(12));
    }
}

package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlienDictionaryTests {
    private AlienDictionary alienDictionary;

    @Before
    public void setup() {
        alienDictionary = new AlienDictionary();
    }

    @Test
    public void testExample1() {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        assertEquals("wertf", alienDictionary.alienOrder(words));
    }

    @Test
    public void testExample2() {
        String[] words = {"zy","zx"};
        assertEquals("yxz", alienDictionary.alienOrder(words));
    }

    @Test
    public void testExample3() {
        String[] words = {"ab","adc"};
        assertEquals("abcd", alienDictionary.alienOrder(words));
    }
}

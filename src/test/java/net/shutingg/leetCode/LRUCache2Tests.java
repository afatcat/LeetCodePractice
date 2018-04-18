package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LRUCache2Tests {
    private LRUCache2 lruCache2;
    @Before
    public void setup() {
        lruCache2 = new LRUCache2(3);
    }

    @Test
    public void testLRU() {
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        lruCache2.put(3, 3);
        lruCache2.put(4, 4);
        assertEquals(4, lruCache2.get(4));
        assertEquals(3, lruCache2.get(3));
        assertEquals(2, lruCache2.get(2));
        assertEquals(-1, lruCache2.get(1));
        lruCache2.put(5, 5);
        assertEquals(-1, lruCache2.get(1));
        assertEquals(2, lruCache2.get(2));
        assertEquals(3, lruCache2.get(3));
        assertEquals(-1, lruCache2.get(4));
        assertEquals(5, lruCache2.get(5));

    }
}

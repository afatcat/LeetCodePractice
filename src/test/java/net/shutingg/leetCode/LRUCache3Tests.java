package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCache3Tests {
    private LRUCache3 lruCache;
    @Before
    public void setup() {
        lruCache = new LRUCache3(3);
    }

    @Test
    public void testLRU() {
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        assertEquals(4, lruCache.get(4));
        assertEquals(3, lruCache.get(3));
        assertEquals(2, lruCache.get(2));
        assertEquals(-1, lruCache.get(1));
        lruCache.set(5, 5);
        assertEquals(-1, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
        assertEquals(-1, lruCache.get(4));
        assertEquals(5, lruCache.get(5));

    }
}

package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CopyBooksTests {
    private CopyBooks copyBooks;

    @Before
    public void setup(){
        copyBooks = new CopyBooks();
    }

    @Test
    public void testCopyBooks(){
        assertEquals(5, copyBooks.copyBooks(new int[]{3,2,4}, 2));
        assertEquals(9, copyBooks.copyBooks(new int[]{3,2,4,5}, 2));
    }
}

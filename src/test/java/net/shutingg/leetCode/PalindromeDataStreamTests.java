package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PalindromeDataStreamTests {
    private PalindromeDataStream palindromeDataStream;

    @Before
    public void setup() {
        palindromeDataStream = new PalindromeDataStream();
    }

    @Test
    public void testGetStream() {
        assertThat(palindromeDataStream.getStream("bbbabbb"), is(new int[]{1, 1, 1, 0, 1, 0, 1}));
        assertThat(palindromeDataStream.getStream("abababa"), is(new int[]{1, 0, 1, 1, 1, 0, 1}));
        assertThat(palindromeDataStream.getStream("abababac"), is(new int[]{1, 0, 1, 1, 1, 0, 1, 0}));
        assertThat(palindromeDataStream.getStream("cabbae"), is(new int[]{1, 0, 0, 0, 1, 0}));
    }
}

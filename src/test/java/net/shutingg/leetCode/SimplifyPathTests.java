package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimplifyPathTests {
    private SimplifyPath simplifyPath;
    @Before
    public void setup(){
        simplifyPath = new SimplifyPath();
    }

    @Test
    public void testSimplifyPath(){
        assertEquals("/", simplifyPath.simplifyPath("/.."));
        assertEquals("/...", simplifyPath.simplifyPath("/...")); // it should be an error, but since that's what's expected in the question...
        assertEquals("/home", simplifyPath.simplifyPath("/home/"));
        assertEquals("/", simplifyPath.simplifyPath("/home/.."));
        assertEquals("/home", simplifyPath.simplifyPath("/home/."));
        assertEquals("/...", simplifyPath.simplifyPath("/.../"));
        assertEquals("/home/foo/bar", simplifyPath.simplifyPath("/home/foo/./bar/"));
    }
}

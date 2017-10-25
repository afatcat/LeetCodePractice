package net.shutingg.leetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sguan on 10/25/17.
 */
public class ConvertNumber2HexadecimalTests {
    private ConvertNumber2Hexadecimal convertNumber2Hexadecimal;
    long startTime;
    long endTime;
    @Before
    public void setup(){
        convertNumber2Hexadecimal = new ConvertNumber2Hexadecimal();
        startTime = System.nanoTime();
    }

    @After
    public void finish(){
        endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }

    @Test
    public void testToHex(){
        //examples in question
        assertEquals("1a", convertNumber2Hexadecimal.toHex(26));
        assertEquals("ffffffff", convertNumber2Hexadecimal.toHex(-1));

        //my cases
        assertEquals("ffffffef", convertNumber2Hexadecimal.toHex(-17));
        assertEquals("0", convertNumber2Hexadecimal.toHex(0));
        assertEquals("fffffff0", convertNumber2Hexadecimal.toHex(-16));
        assertEquals("ffffff00", convertNumber2Hexadecimal.toHex(-256));
        assertEquals("f0000000", convertNumber2Hexadecimal.toHex(-268435456));
        assertEquals("10000000", convertNumber2Hexadecimal.toHex(268435456));
    }

    @Test
    public void testToHex2(){
        //examples in question
        assertEquals("1a", convertNumber2Hexadecimal.toHex2(26));
        assertEquals("ffffffff", convertNumber2Hexadecimal.toHex2(-1));

        //my cases
        assertEquals("ffffffef", convertNumber2Hexadecimal.toHex2(-17));
        assertEquals("0", convertNumber2Hexadecimal.toHex2(0));
        assertEquals("fffffff0", convertNumber2Hexadecimal.toHex2(-16));
        assertEquals("ffffff00", convertNumber2Hexadecimal.toHex2(-256));
        assertEquals("f0000000", convertNumber2Hexadecimal.toHex2(-268435456));
        assertEquals("10000000", convertNumber2Hexadecimal.toHex2(268435456));
    }

    @Test
    public void testToHex3(){
        //examples in question
        assertEquals("1a", convertNumber2Hexadecimal.toHex3(26));
        assertEquals("ffffffff", convertNumber2Hexadecimal.toHex3(-1));

        //my cases
        assertEquals("ffffffef", convertNumber2Hexadecimal.toHex3(-17));
        assertEquals("0", convertNumber2Hexadecimal.toHex3(0));
        assertEquals("fffffff0", convertNumber2Hexadecimal.toHex3(-16));
        assertEquals("ffffff00", convertNumber2Hexadecimal.toHex3(-256));
        assertEquals("f0000000", convertNumber2Hexadecimal.toHex3(-268435456));
        assertEquals("10000000", convertNumber2Hexadecimal.toHex3(268435456));
    }
}

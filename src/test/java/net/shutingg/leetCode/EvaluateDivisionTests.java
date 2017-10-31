package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EvaluateDivisionTests {
    private EvaluateDivision evaluateDivision;
    @Before
    public void setup(){
        evaluateDivision = new EvaluateDivision();
    }

    @Test
    public void testCalcEquation(){
        //example
        String[][] equations = {{"a","b"},{"b","c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] results = {6.0, 0.5, -1.0, 1.0, -1.0};
        assertArrayEquals(results, evaluateDivision.calcEquation(equations, values, queries), 0.0001);

        //test case 2
        String[][] equations2 = {{"a","b"},{"e","f"},{"b","e"}};
        double[] values2 = {3.4,1.4,2.3};
        String[][] queries2 = {{"a","f"},{"f","f"},{"e","e"},{"c","c"},{"a","c"},{"f","e"},{"b","a"}};
        double[] results2 = {10.94800,1.00000,1.00000,-1.00000,-1.00000,0.71429,0.29412};
        assertArrayEquals(results2, evaluateDivision.calcEquation(equations2, values2, queries2), 0.0001);
    }
}

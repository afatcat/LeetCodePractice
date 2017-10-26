package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Dota2SenateTests {
    private Dota2Senate dota2Senate;

    @Before
    public void setup(){
        dota2Senate = new Dota2Senate();
    }
    @Test
    public void testPredictPartyVictory(){
        assertEquals("Radiant", dota2Senate.predictPartyVictory("RD"));
        assertEquals("Dire", dota2Senate.predictPartyVictory("RDD"));
        assertEquals("Dire", dota2Senate.predictPartyVictory("DDRRR"));
        assertEquals("Radiant", dota2Senate.predictPartyVictory("RDRDD"));
        assertEquals("Radiant", dota2Senate.predictPartyVictory("R"));
        assertEquals("Radiant", dota2Senate.predictPartyVictory("RDR"));
        assertEquals("Dire", dota2Senate.predictPartyVictory("DRD"));
        assertEquals("Dire", dota2Senate.predictPartyVictory("DD"));
        assertEquals("Dire", dota2Senate.predictPartyVictory("DRDRD"));
    }
}
